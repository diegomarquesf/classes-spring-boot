package br.com.diegomarques.classes.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class ItemCobertura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cobertura cobertura;

    private BigDecimal vlsegurado;

    @ManyToOne
    @JoinColumn(name = "seguro_id")
    private Seguro seguro;

    public ItemCobertura() {

    }

    public ItemCobertura(Long id, Cobertura cobertura, BigDecimal vlsegurado) {
        this.id = id;
        this.cobertura = cobertura;
        this.vlsegurado = vlsegurado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    public BigDecimal getVlsegurado() {
        return vlsegurado;
    }

    public void setVlsegurado(BigDecimal vlsegurado) {
        this.vlsegurado = vlsegurado;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
