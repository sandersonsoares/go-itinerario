package br.com.itinerario.controller;

import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean extends DefaultBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private Facade fachada;
    private String busca;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    @PostConstruct
    private void init() {
        fachada = new Facade();
        try {
            usuarios = fachada.listarUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvar() {
        try {
            fachada.cadastrarUsuario(usuario);
            return getLinkBean().listaUsuarios();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }

    public void filtrar() {
        try {
            usuarios = fachada.listarUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        Iterator<Usuario> intUsuario = this.usuarios.iterator();
        List<Usuario> tempList = new ArrayList<Usuario>();

        while (intUsuario.hasNext()) {
            Usuario user = intUsuario.next();

            if (user.getNome().contains(busca)
                    || user.getUsername().contains(busca)
                    || user.getCpf().contains(busca)
                    || user.getEmail().contains(busca)) {
                tempList.add(user);
            }
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
