package com.app.service;
import com.app.entity.Exam;
import com.app.repository.ExamRepo;
import java.util.List;

public class ExamService {
ExamRepo repo=new ExamRepo();

public List<Exam> getAll(){return repo.findAll();}

public void create(String name,int duration,String description){
Exam e=new Exam();
e.setName(name);
e.setDuration(duration);
e.setDescription(description);
repo.save(e);
}

public void delete(int id){repo.delete(id);}
}