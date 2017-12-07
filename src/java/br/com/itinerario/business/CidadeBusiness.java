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
public class CidadeBusiness implements Serializable {

    private DaoGeneric<Cidade> cidadeDao;

    public CidadeBusiness() {
        this.cidadeDao = new DAOFactory().createCidadeDAO();
    }

    public synchronized Cidade salvar(Cidade cidade) throws DAOException {
        if (cidade.getId() != null) {
            return this.cidadeDao.update(cidade);
        } else {
            return this.cidadeDao.save(cidade);
        }
    }

    public List<Cidade> listar() throws DAOException {
        return this.cidadeDao.getAll();
    }

    public synchronized Cidade remover(Cidade cidade) throws DAOException {
        return this.cidadeDao.remove(cidade);
    }

    public Cidade buscar(Long id) throws DAOException {
        return this.cidadeDao.getById(id);
    }

}
