package dao;

import model.Attendee;

import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AttendeeDAO {

 
    public void addAttendee(Attendee attendee) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(attendee);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

   
    public List<Attendee> getByEventId(int eventId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Attendee a WHERE a.event.id = :eventId",
                    Attendee.class)
                    .setParameter("eventId", eventId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteAttendee(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Attendee a = em.find(Attendee.class, id);
            if (a != null) {
                em.remove(a);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}