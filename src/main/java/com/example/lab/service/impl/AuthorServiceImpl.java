package com.example.lab.service.impl;

import com.example.lab.entity.AuthorEntity;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorEntity> listAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorEntity findAuthor(Long id) throws Exception {
        return authorRepository.findById(id).orElseThrow(Exception::new);
    }
}
