/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Grupo;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class GrupoBusiness {

    private DaoGeneric gruposDao;

    public GrupoBusiness() {
        this.gruposDao = DAOFactory.createGrupoDAO();
    }

    public void salvar(Grupo grupo) throws DAOException {
        if (grupo.getId() != null) {
            gruposDao.update(grupo);
        } else {
            gruposDao.save(grupo);

        }
    }

    public List<Grupo> listar() throws DAOException {
        return gruposDao.getAll();
    }
    
    public Grupo buscarGrupo(Long id) throws DAOException {
        return (Grupo) gruposDao.getById(id);
    }
}
