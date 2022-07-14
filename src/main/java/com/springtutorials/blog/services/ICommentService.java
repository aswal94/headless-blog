package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> getAllComments();

    Optional<Comment> getCommentById(Long id);

    Comment saveComment(Comment post);

    Comment updateComment(Long id, Comment post);

    void deleteCommentById(Long id);
}
