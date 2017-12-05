package br.com.itinerario.model;

import br.com.itinerario.enums.LadoAssento;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assento implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LadoAssento ladoAssento;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
