/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Usuario;
import java.util.List;

/**
 *
 * @author klerm
 */
public class UsuarioBusiness {

    private DaoGeneric usuarioDao;

    public UsuarioBusiness() {
        this.usuarioDao = DAOFactory.createUsuarioDAO();
    }

    public void salvar(Usuario usuario) throws DAOException {
        usuarioDao.save(usuario);
    }

    public List<Usuario> listar() throws DAOException {
        return usuarioDao.getAll();
    }

}
