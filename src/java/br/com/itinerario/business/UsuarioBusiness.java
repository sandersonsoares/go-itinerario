/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.IUsuarioDAO;
import br.com.itinerario.model.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author klerm
 */
public class UsuarioBusiness {

    private IUsuarioDAO usuarioDao;

    public UsuarioBusiness() {
        this.usuarioDao = DAOFactory.createUsuarioDAO();
    }

    public synchronized void salvar(Usuario usuario) throws DAOException {
        if (usuario.getId() != null) {
            atualizar(usuario);
        } else {
            usuarioDao.save(usuario);
        }
    }

    public synchronized void atualizar(Usuario usuario) throws DAOException {
        usuarioDao.update(usuario);
    }

    public Usuario buscar(Long id) throws DAOException {
        return (Usuario) usuarioDao.getById(id);
    }

    public List<Usuario> listar() throws DAOException {
        return usuarioDao.getAll();
    }

    public Usuario logarUsuario(String login) {
        try {
            return usuarioDao.buscarLogin(login);
        } catch (DAOException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
        return null;
    }

}
