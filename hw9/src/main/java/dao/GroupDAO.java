package dao;

import model.ContactGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class GroupDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTicketPU");

    public List<ContactGroup> getAllGroups() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM ContactGroup g", ContactGroup.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void saveGroup(ContactGroup group) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(group);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}