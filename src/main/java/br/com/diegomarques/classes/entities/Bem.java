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

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getVlEstimado() {
        return vlEstimado;
    }

    public void setVlEstimado(BigDecimal vlEstimado) {
        this.vlEstimado = vlEstimado;
    }

    public abstract String getTipo();

    public BigDecimal calcularValorBase() {
        return vlEstimado;
    }
}
