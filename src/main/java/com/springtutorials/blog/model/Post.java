package com.springtutorials.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Post title required")
    private String title;

    private String slug;

    @NotBlank(message = "Post body required")
    private String body;

    @NotNull(message = "Please specify a post category")
    private Long categoryId;

    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
