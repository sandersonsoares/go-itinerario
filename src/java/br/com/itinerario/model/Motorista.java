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
public class Motorista extends Pessoa implements Serializable{
 
    private String cnh;

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
}