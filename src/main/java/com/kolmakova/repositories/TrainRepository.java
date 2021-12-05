package com.kolmakova.repositories;

import com.kolmakova.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

    @Query(value = "SELECT t FROM Train t WHERE arrival_place LIKE :arrivalPlace")
    List<Train> findTrainByArrival(@Param("arrivalPlace") String arrivalPlace);

    @Query(value = "SELECT t FROM Train t WHERE id=:id")
    Train getTrainById(@Param("id") int id);

    @Query(value = "SELECT t FROM Train t WHERE t.id IN :id")
    List<Train> getTrainsByIdes(@Param("id") Integer[] id);
}
