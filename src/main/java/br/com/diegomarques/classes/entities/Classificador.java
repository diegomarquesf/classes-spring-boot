package br.com.diegomarques.classes.entities;

import br.com.diegomarques.classes.entities.enums.ClassificadorEnum;

public class Classificador implements IClassificador{
    @Override
    public ClassificadorEnum classificar(Cliente cliente) {
        int qtdSeguros = cliente.getSeguros().size();
        if (qtdSeguros > 3) return ClassificadorEnum.VIP;
        if (qtdSeguros > 1) return ClassificadorEnum.REGULAR;
        return ClassificadorEnum.BASICO;
    }
}
