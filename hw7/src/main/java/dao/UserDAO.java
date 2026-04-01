package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.User;

public class UserDAO {
    public User login(String username, String password) {
        EntityManager em = util.JPAUtil.getEM();
        try {
            return em.createQuery(
                    "select u from User u where u.username = :u and u.password = :p ", User.class)
                    .setParameter("u", username)
                    .setParameter("p", password)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }

    public boolean register(User user) {
        EntityManager em = util.JPAUtil.getEM();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin(); 
            em.persist(user); 
            trans.commit(); 
            return true;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean isUsernameExists(String username) {
        EntityManager em = util.JPAUtil.getEM();
        try {
            Long count = em.createQuery(
                    "select count(u) from User u where u.username = :u", Long.class)
                    .setParameter("u", username)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}
