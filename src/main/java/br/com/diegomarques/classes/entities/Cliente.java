package br.com.diegomarques.classes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private List<ISeguro> seguros;
    private IClassificador classificador;

    public Cliente() {

    }

    public Cliente(Long id, String nome, List<ISeguro> seguros, IClassificador classificador) {
        this.id = id;
        this.nome = nome;
        this.seguros = seguros;
        this.classificador = classificador;
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

    public List<ISeguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<ISeguro> seguros) {
        this.seguros = seguros;
    }

    public IClassificador getClassificador() {
        return classificador;
    }

    public void setClassificador(IClassificador classificador) {
        this.classificador = classificador;
    }
}
