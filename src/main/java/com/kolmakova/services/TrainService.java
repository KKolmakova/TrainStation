package com.kolmakova.services;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> list() {
        return trainRepository.findAll();
    }

    public List<Train> getByArrivalPlace(String arrivalPlace) {
        return trainRepository.findTrainByArrival(arrivalPlace);
    }

    public Train getTrainById(int id) {
        return trainRepository.findById(id).orElse(new Train());
    }

    public List<Integer> getTrainsId(List<Train> trains) {
        List<Integer> trainsId = new ArrayList<>();
        for (Train train : trains) {
            trainsId.add(train.getId());
        }

        return trainsId;
    }

    public String getSelectedTrainsUrl(List<Train> trains) {
        List<Integer> ids = getTrainsId(trains);
        return StringUtils.join(ids, ',');
    }

    public List<Train> getTrainsByIds(List<Integer> id) {
        return trainRepository.findAllById(id);
    }

    public List<Train> getByParameters(String arrivalPlace, Date departureDate, Date departureTime) {
        Specification<Train> specification = Specification.where(null);

        if (StringUtils.isNotEmpty(arrivalPlace)) {
            specification = specification.and(matchesArrivalPlace(arrivalPlace));
        }
        if (departureDate != null) {
            specification = specification.and(matchesDepartureDate(departureDate));
        }
        if (departureTime != null) {
            specification = specification.and(matchesDepartureTime(departureTime));
        }

        return trainRepository.findAll(specification);
    }

    public static Specification<Train> matchesArrivalPlace(String arrivalPlace) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("arrivalPlace"), arrivalPlace);
    }

    public static Specification<Train> matchesDepartureDate(Date departureDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("departureDate"), departureDate);
    }

    public static Specification<Train> matchesDepartureTime(Date departureTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("departureTime"), departureTime);
    }
}
