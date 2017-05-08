package br.com.itinerario.model;

import br.com.itinerario.enums.Estados;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cidade implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 255)
    @NotNull
    private String nome;
    @Enumerated(EnumType.STRING)
    private Estados estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", nome=" + nome + ", estado=" + estado + '}';
    }

}
