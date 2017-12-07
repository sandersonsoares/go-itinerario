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

    private DaoGeneric<Grupo> gruposDao;

    public GrupoBusiness() {
        this.gruposDao = DAOFactory.createGrupoDAO();
    }

    public synchronized Grupo salvar(Grupo grupo) throws DAOException {
        if (grupo.getId() != null) {
            return gruposDao.update(grupo);
        } else {
            return gruposDao.save(grupo);

        }
    }

    public Grupo remover(Grupo grupo) throws DAOException {
        return gruposDao.remove(grupo);
    }

    public List<Grupo> listar() throws DAOException {
        return gruposDao.getAll();
    }

    public Grupo buscarGrupo(Long id) throws DAOException {
        return gruposDao.getById(id);
    }
}
