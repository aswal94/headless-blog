package com.springtutorials.blog.services.impl;

import com.springtutorials.blog.model.Tag;
import com.springtutorials.blog.repositories.TagRepository;
import com.springtutorials.blog.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Long id, Tag newTag) {
        return tagRepository.findById(id)
                .map(tag -> {
                    tag.setName(newTag.getName());
                    return tagRepository.save(tag);
                })
                .orElseGet(() -> {
                    newTag.setId(id);
                    return tagRepository.save(newTag);
                });
    }

    @Override
    public void deleteTagById(Long id) {
        tagRepository.deleteById(id);
    }
}
