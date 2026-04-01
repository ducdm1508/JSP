package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    
    private static final String persistenceUnitName = "myPersistenceUnit";

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

    public static EntityManager getEM() {
        return emf.createEntityManager();
    }

}
