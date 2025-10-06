package br.com.diegomarques.classes.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Seguro implements ISeguro, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Bem bem;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCobertura> coberturas;

    private LocalDate dtInicio;
    private LocalDate dtRenovacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Seguro() {

    }

    public Seguro(Long id, Bem bem, List<ItemCobertura> coberturas, LocalDate dtInicio, LocalDate dtRenovacao) {
        this.id = id;
        this.bem = bem;
        this.coberturas = coberturas;
        this.dtInicio = dtInicio;
        this.dtRenovacao = dtRenovacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
    }

    public List<ItemCobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<ItemCobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtRenovacao() {
        return dtRenovacao;
    }

    public void setDtRenovacao(LocalDate dtRenovacao) {
        this.dtRenovacao = dtRenovacao;
    }

    @Override
    public void adicionarCobertura(Cobertura cobertura, BigDecimal vlSegurado) {
        if (vlSegurado == null || vlSegurado.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor segurado deve ser positivo!");

        ItemCobertura item = new ItemCobertura();
        item.setCobertura(cobertura);
        item.setVlsegurado(vlSegurado);
        item.setSeguro(this);
        coberturas.add(item);
    }

    @Override
    public void removerCobertura(Cobertura cobertura) {
        coberturas.removeIf(item -> item.getCobertura().equals(cobertura));
    }
    public BigDecimal calcularPreco() {
        return coberturas.stream()
                .map(item -> item.getVlsegurado().multiply(item.getCobertura().getFatorPeso()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
