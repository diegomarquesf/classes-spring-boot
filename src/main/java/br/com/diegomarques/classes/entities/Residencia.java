package br.com.diegomarques.classes.entities;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Residencia extends Bem implements Serializable {
    private String endereco;
    private double area;
    private String tpConstrucao;

    public Residencia() {

    }

    public Residencia(String endereco, double area, String tpConstrucao) {
        super();
        this.endereco = endereco;
        this.area = area;
        this.tpConstrucao = tpConstrucao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTpConstrucao() {
        return tpConstrucao;
    }

    public void setTpConstrucao(String tpConstrucao) {
        this.tpConstrucao = tpConstrucao;
    }

    @Override
    public String getTipo() {
        return "";
    }
}
