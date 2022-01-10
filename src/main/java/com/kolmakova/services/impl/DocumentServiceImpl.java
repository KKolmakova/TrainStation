package com.kolmakova.services.impl;

import com.kolmakova.entities.Document;
import com.kolmakova.repositories.DocumentRepository;
import com.kolmakova.services.DocumentService;
import com.kolmakova.types.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Optional<Document> getDocuments(DocumentType type) {
        return documentRepository.findByType(type);
    }
}
