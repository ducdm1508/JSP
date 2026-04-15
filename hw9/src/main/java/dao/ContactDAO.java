package dao;

import model.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ContactDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTicketPU");

    public void saveContact(Contact contact) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Contact> getAllContacts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Contact getContactById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Contact.class, id);
        } finally {
            em.close();
        }
    }

    public void updateContact(Contact contact) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteContact(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Contact contact = em.find(Contact.class, id);
            if (contact != null) em.remove(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}