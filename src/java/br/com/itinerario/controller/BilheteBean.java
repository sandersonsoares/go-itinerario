package br.com.itinerario.controller;

import br.com.itinerario.model.Bilhete;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BilheteBean extends DefaultBean {
    
    private Bilhete bilhete;
    private List<Bilhete> bilhetes;

    public BilheteBean() {
        super();
        this.bilhete = new Bilhete();
        this.bilhetes = new ArrayList<>();
    }

    @PostConstruct
    private void init(){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        
        try {
            if (id != null) {
                this.bilhete = this.fachada.buscarBilhete(Long.parseLong(id));
            } else {
                this.bilhete = new Bilhete();
            }
            
            this.bilhetes = fachada.listarBilhetes();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(List<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }
    
    
}
