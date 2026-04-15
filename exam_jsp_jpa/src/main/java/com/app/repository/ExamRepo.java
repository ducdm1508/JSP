package com.app.repository;
import com.app.entity.Exam;
import jakarta.persistence.*;
import java.util.List;

public class ExamRepo {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");

public List<Exam> findAll(){
EntityManager em=emf.createEntityManager();
List<Exam> list=em.createQuery("from Exam",Exam.class).getResultList();
em.close();
return list;
}

public void save(Exam e){
EntityManager em=emf.createEntityManager();
em.getTransaction().begin();
em.persist(e);
em.getTransaction().commit();
em.close();
}

public void delete(int id){
EntityManager em=emf.createEntityManager();
em.getTransaction().begin();
Exam e=em.find(Exam.class,id);
if(e!=null) em.remove(e);
em.getTransaction().commit();
em.close();
}
}