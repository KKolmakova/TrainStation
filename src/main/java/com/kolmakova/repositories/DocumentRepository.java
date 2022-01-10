package com.kolmakova.repositories;

import com.kolmakova.entities.Document;
import com.kolmakova.entities.Train;
import com.kolmakova.types.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    @Query(value = "SELECT d FROM Document d WHERE type LIKE :type")
    Optional<Document> findByType(@Param("type") DocumentType type);
}
