package dao;

import javax.persistence.EntityManager;

import model.User;
import util.JPAUtil;

public class UserDAO {
    public void saveUser(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
