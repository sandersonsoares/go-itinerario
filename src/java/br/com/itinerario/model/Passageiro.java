package br.com.itinerario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "passageiro")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Passageiro extends Pessoa implements Serializable{
    
    private boolean estudante;

    public boolean isEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }
    
}
