package org.example.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;

public class EntityService implements Closeable {
    private final EntityManagerFactory entityManagerFactory;
    public final EntityManager em;
    public EntityService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("some");
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() throws IOException {
        em.close();
        entityManagerFactory.close();
    }
}
