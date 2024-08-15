package me.kinaz.tourserviceplatform.conf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PersistenceManager {

    private static final String PERSISTENCE_UNIT_NAME = "tourservicePU";
    private EntityManagerFactory emf;

    public PersistenceManager() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", "your_mysql_url");
        properties.put("jakarta.persistence.jdbc.user", "your_mysql_user");
        properties.put("jakarta.persistence.jdbc.password", "your_mysql_password");
        properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
    }

    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    @Produces
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
