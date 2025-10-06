package br.com.diegomarques.classes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Cobertura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal fatorPeso;

    public Cobertura() {

    }

    public Cobertura(Long id, String nome, BigDecimal fatorPeso) {
        this.id = id;
        this.nome = nome;
        this.fatorPeso = fatorPeso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getFatorPeso() {
        return fatorPeso;
    }

    public void setFatorPeso(BigDecimal fatorPeso) {
        this.fatorPeso = fatorPeso;
    }
}
