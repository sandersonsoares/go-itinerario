package br.com.itinerario.model;

import br.com.itinerario.enums.TipoDocumento;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "passageiro")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Passageiro extends Pessoa implements Serializable{
    
    private boolean estudante;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    public Passageiro() {
        this.estudante = false;
    }
    
    public boolean isEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
}
