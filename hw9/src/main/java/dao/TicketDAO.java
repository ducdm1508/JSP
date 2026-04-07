package dao;

import model.Ticket;
import jakarta.persistence.*;
import java.util.List;

public class TicketDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTicketPU");

    public void save(Ticket ticket) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Ticket> findTickets(String searchKeyword, int page, int pageSize) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT t FROM Ticket t";
            if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
                jpql += " WHERE t.eventName LIKE :keyword OR t.customerName LIKE :keyword";
            }
            TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
            if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
                query.setParameter("keyword", "%" + searchKeyword.trim() + "%");
            }

            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public long countTickets(String searchKeyword) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT COUNT(t) FROM Ticket t";
            if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
                jpql += " WHERE t.eventName LIKE :keyword OR t.customerName LIKE :keyword";
            }
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
                query.setParameter("keyword", "%" + searchKeyword.trim() + "%");
            }
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}