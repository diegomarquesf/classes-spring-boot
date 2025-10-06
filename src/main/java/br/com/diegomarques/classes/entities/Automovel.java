package br.com.diegomarques.classes.entities;

import java.io.Serializable;

public class Automovel extends Bem implements Serializable {
    private String placa;
    private int ano;
    private String modelo;

    public Automovel() {

    }

    public Automovel(String placa, int ano, String modelo) {
        super();
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getTipo() {
        return "";
    }
}
