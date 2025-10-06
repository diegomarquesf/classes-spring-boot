package br.com.diegomarques.classes.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Bem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal vlEstimado;

    public Bem() {

    }

    public Bem(Long id, String descricao, BigDecimal vlEstimado) {
        this.id = id;
        this.descricao = descricao;
        this.vlEstimado = vlEstimado;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getVlEstimado() {
        return vlEstimado;
    }
    public abstract String getTipo();

    public BigDecimal calcularValorBase() {
        return vlEstimado;
    }
}
