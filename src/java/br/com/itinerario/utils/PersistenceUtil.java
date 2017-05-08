package br.com.itinerario.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class PersistenceUtil {

    private static String nomeDaUnidadeDePersistencia;
    private static EntityManagerFactory entityManagerFactory = null;
    private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

    public PersistenceUtil() {
    }

    static {
        nomeDaUnidadeDePersistencia = PropertiesUtil.getSettings(PropertiesUtil.SETTINGS_UP_NAME);
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(nomeDaUnidadeDePersistencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        try {
            EntityManager entityManager = threadEntityManager.get();
            if (entityManager == null || !entityManager.isOpen()) {
                entityManager = entityManagerFactory.createEntityManager();
                PersistenceUtil.threadEntityManager.set(entityManager);
            }
            return entityManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeEntityManager() {
        EntityManager em = threadEntityManager.get();
        if (em != null) {
            EntityTransaction transaction = em.getTransaction();
            if (transaction.isActive()) {
                transaction.commit();
            }
            em.close();
            threadEntityManager.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        entityManagerFactory.close();
    }

}
