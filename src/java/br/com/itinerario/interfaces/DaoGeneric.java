package br.com.itinerario.interfaces;


import br.com.itinerario.exception.DAOException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public interface DaoGeneric<T> {

    T save(T t) throws DAOException;

    T update(T t) throws DAOException;

    T remove(T t) throws DAOException;

    T merge(T t) throws DAOException;

    T getById(Long id) throws DAOException;

    List<T> getAllOrderByAsc(String arg) throws DAOException;

    List<T> getAllOrderByDesc(String arg) throws DAOException;

    List<T> getAll() throws DAOException;

    Session getSession();

    Criteria getCriteria();

    T executeNativeQuerySingleResult(String sql) throws DAOException;

    List<T> executeNativeQueryMultiResult(String sql) throws DAOException;
}
