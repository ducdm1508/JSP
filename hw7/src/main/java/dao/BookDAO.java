package dao;

import java.util.List;


import jakarta.persistence.EntityManager;
import model.Book;

public class BookDAO {
    public List<Book> getAllBooks() {
        EntityManager em = util.JPAUtil.getEM();
        try {
            return em.createQuery("select b from Book b", Book.class).getResultList();
        } finally {
            em.close();
        }
    }

        public void addBook(Book book) {
            EntityManager em = util.JPAUtil.getEM();
            try {
                em.getTransaction().begin();
                em.persist(book);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }

        public void deleteBook(int id) {
            EntityManager em = util.JPAUtil.getEM();
            try {
                em.getTransaction().begin();
                Book b = em.find(Book.class, id);
                if (b != null) {
                    em.remove(b);
                }
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }
}
