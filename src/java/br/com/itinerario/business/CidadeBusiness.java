package br.com.itinerario.business;

import br.com.itinerario.dao.DaoGenericImpl;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.model.Cidade;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class CidadeBusiness implements Serializable {

    private DaoGenericImpl<Cidade> cidadeDao;

    public CidadeBusiness() {
        this.cidadeDao = DAOFactory.createCidadeDAO();
    }

    public synchronized Cidade salvar(Cidade cidade) throws DAOException {
        if (cidade.getId() != null) {
            return (Cidade) this.cidadeDao.update(cidade);
        } else {
            return (Cidade) this.cidadeDao.save(cidade);
        }
    }

    public List<Cidade> listar() throws DAOException {
        return this.cidadeDao.getAll();
    }

    public synchronized Cidade remover(Cidade cidade) throws DAOException {
        return (Cidade) this.cidadeDao.remove(cidade);
    }

    public Cidade buscar(Long id) throws DAOException {
        return (Cidade) this.cidadeDao.getById(id);
    }

}
