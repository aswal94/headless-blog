package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Tag;

import java.util.List;
import java.util.Optional;

public interface ITagService {
    List<Tag> getAllTags();

    Optional<Tag> getTagById(Long id);

    Tag saveTag(Tag post);

    Tag updateTag(Long id, Tag post);

    void deleteTagById(Long id);
}
