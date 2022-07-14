package com.springtutorials.blog.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String body;
    private Long userID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
