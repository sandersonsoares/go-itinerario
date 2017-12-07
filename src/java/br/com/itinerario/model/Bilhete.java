package br.com.itinerario.model;

import br.com.itinerario.enums.Situacao;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bilhete implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int numero;
    private String assento;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Passageiro passageiro;
    @ManyToOne(cascade = CascadeType.ALL)
    private Rota rota;
    @ManyToOne(cascade = CascadeType.ALL)
    private Veiculo veiculo;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", numero=" + numero + ", assento=" + assento + ", valor=" + valor + " }";
    }

}
