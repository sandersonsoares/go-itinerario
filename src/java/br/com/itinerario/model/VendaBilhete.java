package br.com.itinerario.model;

import br.com.itinerario.enums.FormaPagamento;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sandersoon
 */
@Entity
public class VendaBilhete implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bilhete> bilhetes;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private double valorTotal;
    private double desconto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(List<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

}
