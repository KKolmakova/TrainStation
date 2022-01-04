package com.kolmakova.utils;

import com.kolmakova.entities.Train;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class TrainUtils {

    public static Specification<Train> getWithParams(String arrivalPlace, Date departureDate, Date departureTime){
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

        return specification;
    }
    private static Specification<Train> matchesArrivalPlace(String arrivalPlace) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("arrivalPlace"), arrivalPlace);
    }

    private static Specification<Train> matchesDepartureDate(Date departureDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("departureDate"), departureDate);
    }

    private static Specification<Train> matchesDepartureTime(Date departureTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("departureTime"), departureTime);
    }
}
