package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Category;

public class CategoryDAO {
    public List<Category> getAllCategories() {
        EntityManager em = util.JPAUtil.getEM();
        try {
            return em.createQuery("select c from Category c", Category.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Category getCategoryById(int id) {
        EntityManager em = util.JPAUtil.getEM();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }
}
