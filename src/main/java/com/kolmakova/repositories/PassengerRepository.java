package com.kolmakova.repositories;

import com.kolmakova.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
