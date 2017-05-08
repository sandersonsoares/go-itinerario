/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 
    private String cng;

    public String getCng() {
        return cng;
    }

    public void setCng(String cng) {
        this.cng = cng;
    }
    
}