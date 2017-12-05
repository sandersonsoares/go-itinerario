package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Bilhete;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class BilheteBusiness implements Serializable {

    private DaoGeneric bilheteDao;
    
     public BilheteBusiness() {
        this.bilheteDao = DAOFactory.createBilheteDAO();
    }

    public synchronized void salvar(Bilhete bilhete) throws DAOException {
        if (bilhete.getId() != null) {
            this.bilheteDao.update(bilhete);
        } else {
            this.bilheteDao.save(bilhete);
        }
    }

    public List<Bilhete> listar() throws DAOException {
        return this.bilheteDao.getAll();
    }

    public synchronized void remover(Bilhete bilhete) throws DAOException {
        this.bilheteDao.remove(bilhete);
    }

    public Bilhete buscar(Long id) throws DAOException {
        return (Bilhete) this.bilheteDao.getById(id);
    }
}
