package br.com.itinerario.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Usuario extends Pessoa implements Serializable {

    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(min = 6, max = 20)
    private String senha;
    @OneToOne
    private Grupo grupo;
    private boolean status;

    public Usuario() {
        grupo = new Grupo();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    

    @Override
    public String toString() {
        return this.username;
    }
}
