package com.example.service;

import com.example.entity.Exam;
import com.example.repository.ExamRepository;
import java.util.List;

public class ExamService {
    private ExamRepository repo = new ExamRepository();

    public void create(String name, int duration, String description) {
        Exam e = new Exam();
        e.setName(name);
        e.setDuration(duration);
        e.setDescription(description);
        repo.save(e);
    }

    public List<Exam> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.delete(id);
    }
}
