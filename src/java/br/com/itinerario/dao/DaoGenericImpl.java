package br.com.itinerario.dao;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.utils.ExceptionsType;
import br.com.itinerario.utils.PersistenceUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class DaoGenericImpl<T> implements DaoGeneric<T> {

    private Class classe;

    public DaoGenericImpl() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T t) throws DAOException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(t);
            manager.flush();
            manager.refresh(t);
            tx.commit();
            return t;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.INSERT_ERROR), e);
        }
    }

    @Override
    public T update(T t) throws DAOException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            t = manager.merge(t);
            manager.flush();
            manager.refresh(t);
            tx.commit();
            return t;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.UPDATE_ERROR), e);
        }
    }

    @Override
    public T remove(T t) throws DAOException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            t = manager.merge(t);
            manager.remove(t);
            manager.flush();
            tx.commit();
            return t;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.REMOVE_ERROR), e);
        }
    }

    @Override
    public T merge(T t) throws DAOException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            return manager.merge(t);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.REMOVE_ERROR), e);
        }
    }

    @Override
    public T getById(Long id) throws DAOException {
        T resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("id", id));
            resultado = (T) criteria.uniqueResult();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

    @Override
    public List<T> getAllOrderByAsc(String arg) throws DAOException {
        List<T> resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            criteria.addOrder(Order.asc(arg));
            resultado = (List<T>) criteria.list();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

    @Override
    public List<T> getAllOrderByDesc(String arg) throws DAOException {
        List<T> resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            criteria.addOrder(Order.desc(arg));
            resultado = (List<T>) criteria.list();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

    @Override
    public List<T> getAll() throws DAOException {
        List<T> resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            criteria.addOrder(Order.desc("id"));
            resultado = (List<T>) criteria.list();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

    @Override
    public Criteria getCriteria() {
        EntityManager manager = PersistenceUtil.getEntityManager();
        return ((Session) manager.getDelegate()).createCriteria(classe);
    }

    @Override
    public Session getSession() {
        EntityManager manager = PersistenceUtil.getEntityManager();
        return ((Session) manager.getDelegate());
    }

    @Override
    public T executeNativeQuerySingleResult(String sql) throws DAOException {
        T resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Query query = manager.createNativeQuery(sql, classe);
            resultado = (T) query.getSingleResult();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

    @Override
    public List<T> executeNativeQueryMultiResult(String sql) throws DAOException {
        List<T> resultado = null;
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            Query query = manager.createNativeQuery(sql, classe);
            resultado = (List<T>) query.getResultList();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(ExceptionsType.getMessage(ExceptionsType.READ_ERROR), e);
        }
    }

}
