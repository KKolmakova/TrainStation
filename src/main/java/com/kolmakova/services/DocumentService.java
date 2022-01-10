package com.kolmakova.services;

import com.kolmakova.entities.Document;
import com.kolmakova.types.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Optional<Document> getDocuments(DocumentType type);
}
