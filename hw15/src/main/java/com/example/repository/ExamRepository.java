package com.example.repository;

import com.example.entity.Exam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ExamRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examPU");

    public void save(Exam exam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
    }

    public List<Exam> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Exam> list = em.createQuery("from Exam", Exam.class).getResultList();
        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Exam exam = em.find(Exam.class, id);
        if (exam != null) em.remove(exam);
        em.getTransaction().commit();
        em.close();
    }
}
