package com.springtutorials.blog.repositories;

import com.springtutorials.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
