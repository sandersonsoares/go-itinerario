package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Motorista;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class MotoristaBusiness {
     private DaoGeneric motoristaDao;
    
     public MotoristaBusiness() {
        this.motoristaDao = DAOFactory.createBilheteDAO();
    }

    public synchronized void salvar(Motorista motorista) throws DAOException {
        if (motorista.getId() != null) {
            motoristaDao.update(motorista);
        } else {
            motoristaDao.save(motorista);
        }
    }

    public List<Motorista> listar() throws DAOException {
        return motoristaDao.getAll();
    }

    public synchronized void remover(Motorista motorista) throws DAOException {
        this.motoristaDao.remove(motorista);
    }

    public Motorista buscar(Long id) throws DAOException {
        return (Motorista) this.motoristaDao.getById(id);
    }
}
