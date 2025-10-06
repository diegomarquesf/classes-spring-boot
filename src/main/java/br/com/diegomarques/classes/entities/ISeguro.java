package br.com.diegomarques.classes.entities;

import java.math.BigDecimal;

public interface ISeguro {
    void adicionarCobertura(Cobertura cobertura, BigDecimal vlSegurado);
    void removerCobertura(Cobertura cobertura);
}
