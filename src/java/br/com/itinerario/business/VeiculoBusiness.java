/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Veiculo;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class VeiculoBusiness {

    private DaoGeneric<Veiculo> veiculoDao;

    public VeiculoBusiness() {
        this.veiculoDao = DAOFactory.createVeiculoDAO();
    }

    public synchronized Veiculo salvar(Veiculo veiculo) throws DAOException {
        if (veiculo.getId() != null) {
            return veiculoDao.update(veiculo);
        } else {
            return veiculoDao.save(veiculo);
        }
    }

    public List<Veiculo> listar() throws DAOException {
        return veiculoDao.getAll();
    }

    public synchronized Veiculo remover(Veiculo veiculo) throws DAOException {
        return veiculoDao.remove(veiculo);
    }

    public Veiculo buscar(Long id) throws DAOException {
        return veiculoDao.getById(id);
    }
}
