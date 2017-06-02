/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Onibus;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Sanderson
 */
public class OnibusBusiness {

    private DaoGeneric onibusDao;

    public OnibusBusiness() {
        this.onibusDao = DAOFactory.createOnibusDAO();
    }

    public synchronized void salvar(Onibus onibus) throws DAOException {
        if (onibus.getId() != null) {
            onibusDao.update(onibus);
        } else {
            onibusDao.save(onibus);
        }
    }

    public List<Onibus> listar() throws DAOException {
        return onibusDao.getAll();
    }

    public synchronized void remover(Onibus onibus) throws DAOException {
        onibusDao.remove(onibus);
    }

    public Onibus buscar(Long id) throws DAOException {
        return (Onibus) onibusDao.getById(id);
    }
}
