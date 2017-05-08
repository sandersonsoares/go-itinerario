/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Passageiro;
import br.com.itinerario.factory.DAOFactory;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sandersoon
 */
public class PassageiroBusiness implements Serializable {

    private DaoGeneric passageiroDao;

    public PassageiroBusiness() {
        passageiroDao = DAOFactory.createPassageiroDAO();
    }

    public void salvar(Passageiro passageiro) throws DAOException {
        passageiroDao.save(passageiro);
    }
    
    public List<Passageiro> listar() throws DAOException {
       return passageiroDao.getAll();
    }
}
