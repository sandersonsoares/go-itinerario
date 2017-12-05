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

    private DaoGeneric rotaDao;

    public RotaBusiness() {
        this.rotaDao = DAOFactory.createRotaDAO();
    }

    public synchronized void salvar(Rota rota) throws DAOException {
        if (rota.getId() != null) {
            rotaDao.update(rota);
        } else {
            rotaDao.save(rota);
        }
    }

    public List<Rota> listar() throws DAOException {
        return rotaDao.getAll();
    }

    public synchronized void remover(Rota rota) throws DAOException {
        rotaDao.remove(rota);
    }

    public Rota buscar(Long id) throws DAOException {
        return (Rota) rotaDao.getById(id);
    }
}
