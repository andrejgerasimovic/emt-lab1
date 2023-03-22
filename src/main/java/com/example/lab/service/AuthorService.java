package com.example.lab.service;

import com.example.lab.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorEntity> listAllAuthors();

    AuthorEntity findAuthor(Long id) throws Exception;
}
