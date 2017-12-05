package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Cidade;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class CidadeBusiness implements Serializable{
    
    private DaoGeneric cidadeDao;
    
     public CidadeBusiness() {
        this.cidadeDao = DAOFactory.createCidadeDAO();
    }

    public synchronized void salvar(Cidade cidade) throws DAOException {
        if (cidade.getId() != null) {
            this.cidadeDao.update(cidade);
        } else {
            this.cidadeDao.save(cidade);
        }
    }

    public List<Cidade> listar() throws DAOException {
        return this.cidadeDao.getAll();
    }

    public synchronized void remover(Cidade cidade) throws DAOException {
        this.cidadeDao.remove(cidade);
    }

    public Cidade buscar(Long id) throws DAOException {
        return (Cidade) this.cidadeDao.getById(id);
    }
    
}
