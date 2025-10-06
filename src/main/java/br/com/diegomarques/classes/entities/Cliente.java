package br.com.diegomarques.classes.entities;

import br.com.diegomarques.classes.entities.enums.ClassificadorEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seguro> seguros;

    public Cliente() {

    }

    public Cliente(Long id, String nome, List<Seguro> seguros) {
        this.id = id;
        this.nome = nome;
        this.seguros = seguros;
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

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public ClassificadorEnum getClassificacao() {
        return new Classificador().classificar(this);
    }
}
