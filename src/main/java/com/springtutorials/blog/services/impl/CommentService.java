package com.springtutorials.blog.services.impl;

import com.springtutorials.blog.model.Comment;
import com.springtutorials.blog.repositories.CommentRepository;
import com.springtutorials.blog.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment newComment) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setBody(newComment.getBody());
                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setId(id);
                    return commentRepository.save(newComment);
                });
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
