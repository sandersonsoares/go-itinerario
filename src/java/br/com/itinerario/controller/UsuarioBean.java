package br.com.itinerario.controller;

import br.com.itinerario.enums.Estados;
import br.com.itinerario.enums.Sexo;
import br.com.itinerario.exception.DAOException;
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
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioBean extends DefaultBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private Facade fachada;
    private String busca;

    private RequestBean requestBean;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        fachada = new Facade();
        if (id != null) {
            try {
                this.usuario = fachada.buscarUsuario(Long.parseLong(id));
            } catch (DAOException ex) {
                imprimirErro(ex.getMessage());
            }
        }

        try {
            usuarios = fachada.listarUsuarios();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public Sexo[] getListarSexos() {
        return Sexo.values();
    }

    public Estados[] getListarEstados() {
        return Estados.values();
    }

    public String salvar() {
        try {
            if (usuario.getId() != null) {
                fachada.atualizarUsuario(usuario);
            } else {
                fachada.cadastrarUsuario(usuario);
            }
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
            imprimirErro(ex.getMessage());
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
