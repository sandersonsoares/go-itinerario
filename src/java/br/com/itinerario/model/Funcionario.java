package br.com.itinerario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Sandersoon
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Funcionario extends Pessoa implements Serializable{
    
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
