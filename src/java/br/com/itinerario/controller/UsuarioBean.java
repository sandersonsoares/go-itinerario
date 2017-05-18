package br.com.itinerario.controller;

import br.com.itinerario.model.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> usuarios;

    public UsuarioBean() {
    }

    @PostConstruct
    private void init() {

    }

}
