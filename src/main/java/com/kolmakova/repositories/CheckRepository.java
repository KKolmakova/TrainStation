package com.kolmakova.repositories;

import com.kolmakova.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<Check, Integer> {
}
