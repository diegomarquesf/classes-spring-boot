package br.com.diegomarques.classes.entities;

import br.com.diegomarques.classes.entities.enums.ClassificadorEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class Classificador implements IClassificador {

    private static final BigDecimal LIMITE_VALOR_VIP = new BigDecimal("10000");
    private static final int LIMITE_QTD_SEGUROS_VIP = 3;
    private static final long ANOS_CLIENTE_ANTIGO = 8;

    @Override
    public ClassificadorEnum classificar(Cliente cliente) {
        int qtdSeguros = cliente.getSeguros() != null ? cliente.getSeguros().size() : 0;

        BigDecimal valorTotal = cliente.getSeguros() != null ?
                cliente.getSeguros().stream()
                        .map(Seguro::calcularPreco)
                        .reduce(BigDecimal.ZERO, BigDecimal::add) : BigDecimal.ZERO;

        boolean clienteAntigo = cliente.getSeguros() != null &&
                cliente.getSeguros().stream()
                        .map(Seguro::getDtInicio)
                        .filter(dt -> dt != null)
                        .anyMatch(dt -> dt.isBefore(LocalDate.now().minusYears(ANOS_CLIENTE_ANTIGO)));

        Set<String> tiposBens = cliente.getSeguros() != null ?
                cliente.getSeguros().stream()
                        .filter(seguro -> seguro.getBem() != null)
                        .map(seguro -> seguro.getBem().getTipo())
                        .collect(Collectors.toSet()) : Set.of();
        boolean temResidencia = tiposBens.contains("Residencia");
        boolean temAutomovel = tiposBens.contains("Automovel");


        if ((valorTotal.compareTo(LIMITE_VALOR_VIP) > 0 && qtdSeguros > LIMITE_QTD_SEGUROS_VIP) ||
                (temResidencia && temAutomovel && clienteAntigo)) {
            return ClassificadorEnum.VIP;
        } else if (qtdSeguros > 1 || temAutomovel) {
            return ClassificadorEnum.REGULAR;
        } else {
            return ClassificadorEnum.BASICO;
        }
    }
}
