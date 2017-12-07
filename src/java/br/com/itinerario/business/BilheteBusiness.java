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

    private DaoGeneric<Bilhete> bilheteDao;

    public BilheteBusiness() {
        this.bilheteDao = DAOFactory.createBilheteDAO();
    }

    public synchronized Bilhete salvar(Bilhete bilhete) throws DAOException {
        if (bilhete.getId() != null) {
            return this.bilheteDao.update(bilhete);
        } else {
            return this.bilheteDao.save(bilhete);
        }
    }

    public List<Bilhete> listar() throws DAOException {
        return this.bilheteDao.getAll();
    }

    public synchronized Bilhete remover(Bilhete bilhete) throws DAOException {
        return this.bilheteDao.remove(bilhete);
    }

    public Bilhete buscar(Long id) throws DAOException {
        return (Bilhete) this.bilheteDao.getById(id);
    }
}
