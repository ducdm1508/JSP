package com.app.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="exams")
public class Exam {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private Integer duration;
private String description;
private LocalDateTime created_at;
private LocalDateTime updated_at;

@PrePersist
public void pre(){
created_at=LocalDateTime.now();
updated_at=LocalDateTime.now();
}
@PreUpdate
public void preU(){
updated_at=LocalDateTime.now();
}

public Integer getId(){return id;}
public String getName(){return name;}
public void setName(String name){this.name=name;}
public Integer getDuration(){return duration;}
public void setDuration(Integer duration){this.duration=duration;}
public String getDescription(){return description;}
public void setDescription(String description){this.description=description;}
public LocalDateTime getCreated_at(){return created_at;}
public LocalDateTime getUpdated_at(){return updated_at;}
}