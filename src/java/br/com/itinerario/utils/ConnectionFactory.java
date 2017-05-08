package br.com.itinerario.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ConnectionFactory {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory = null;
    private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

    static {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SistemaItinerarioWebPU");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        try {
            EntityManager entityManager = threadEntityManager.get();
            if (entityManager == null || !entityManager.isOpen()) {
                entityManager = entityManagerFactory.createEntityManager();
                ConnectionFactory.threadEntityManager.set(entityManager);
            }
            return entityManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
