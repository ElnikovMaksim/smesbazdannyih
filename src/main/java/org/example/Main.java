package org.example;

import javax.persistence.*;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.controllers.MainController;
import org.example.models.Contact;
import org.example.models.User;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        var controller = new MainController();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Petya");

        Contact cont = new Contact();
        cont.setPhone("+798765238562");
        cont.setContactName("Eric cont name");
        cont.setEmail("987878@ya.ru");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "8935449thj319t");
        meta.put("userId", 1);
        meta.put("time", new Date().getTime());

        controller.addContact(user1, cont, meta);
        controller.close();

    }
}
