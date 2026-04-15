package com.example;

import com.example.service.ExamService;

public class Main {
    public static void main(String[] args) {
        ExamService service = new ExamService();
        service.create("Test", 60, "Sample");
        service.getAll().forEach(e -> System.out.println(e.getName()));
    }
}
