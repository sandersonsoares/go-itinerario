package br.com.itinerario.interfaces;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Usuario;

/**
 *
 * @author Sanderson
 */
public interface IUsuarioDAO extends DaoGeneric<Usuario> {

    public Usuario buscarLogin(String login) throws DAOException;
}
