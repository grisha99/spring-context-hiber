package ru.grishchenko.configs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBFactory {

    private SessionFactory factory;

    private static DBFactory dbFactory;

    public SessionFactory getFactory() {
        return factory;
    }


    private DBFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static DBFactory getInstance() {
        if (dbFactory == null) {
            dbFactory = new DBFactory();
        }
        return dbFactory;
    }
}
