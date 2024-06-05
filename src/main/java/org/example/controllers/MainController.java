package org.example.controllers;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.models.Contact;
import org.example.models.User;
import org.example.services.EntityService;
import org.example.services.LogService;

import javax.persistence.EntityManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;

public class MainController implements Closeable {
    LogService log;
    EntityService entity;
    public MainController() {
        log = new LogService();
        entity = new EntityService();
    }

    @Override
    public void close() throws IOException {
        entity.close();
        log.close();
    }
    public void addContact(User user, Contact contact, HashMap<String, Object> meta) {
        contact.setUser(user);
        entity.em.getTransaction().begin();
        entity.em.persist(contact);
        entity.em.getTransaction().commit();

        meta.put("action", "createContact");
        meta.put("newContactId", contact.getId());

        log.add(meta);
    }
}
