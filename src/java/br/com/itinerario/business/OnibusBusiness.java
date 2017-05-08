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

/**
 *
 * @author Sanderson
 */
public class OnibusBusiness {
    private DaoGeneric onibusDao;

    public OnibusBusiness() {
        this.onibusDao = DAOFactory.createOnibusDAO();
    }
    
     public void salvar(Onibus onibus) throws DAOException {
        onibusDao.save(onibus);
    }

    public List<Onibus> listar() throws DAOException {
       return onibusDao.getAll();
    }
}
