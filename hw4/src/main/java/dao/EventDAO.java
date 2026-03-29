package dao;

import model.Event;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EventDAO {

    public void addEvent(Event event) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    public List<Event> getAllEvents() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Event e", Event.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }


    public Event getEventById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Event.class, id);
        } finally {
            em.close();
        }
    }


    public void deleteEvent(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Event e = em.find(Event.class, id);
            if (e != null) {
                em.remove(e);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}