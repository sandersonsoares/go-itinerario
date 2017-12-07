package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Rota;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class RotaBusiness {

    private DaoGeneric<Rota> rotaDao;

    public RotaBusiness() {
        this.rotaDao = DAOFactory.createRotaDAO();
    }

    public synchronized Rota salvar(Rota rota) throws DAOException {
        if (rota.getId() != null) {
            return rotaDao.update(rota);
        } else {
            return rotaDao.save(rota);
        }
    }

    public List<Rota> listar() throws DAOException {
        return rotaDao.getAll();
    }

    public synchronized Rota remover(Rota rota) throws DAOException {
        return rotaDao.remove(rota);
    }

    public Rota buscar(Long id) throws DAOException {
        return rotaDao.getById(id);
    }
}
