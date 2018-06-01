package com.travel.agency.repository;

import com.travel.agency.Entity.RandomTourBuilder;
import com.travel.agency.Entity.Tour;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.travel.agency.Entity.RandomTourBuilder.getCountryCount;

/*репозиторий для доступа к данным о турах*/
@Repository
public class TourRepositoryImpl implements TourRepository {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private int TOUR_SIZE = 10;

    private List<Tour> availableTours = generateTourList(TOUR_SIZE);

    /*получить все туры*/
    public List<Tour> findAll() {
        return Collections.unmodifiableList(availableTours);
    }

    /*сгенерировать список заданного размера из случайных туров*/
    private static List<Tour> generateTourList(int size) {
        return new Random()
                .ints(0, getCountryCount())
                .mapToObj(RandomTourBuilder::getInstance)
                .map(RandomTourBuilder::build)
                .distinct()
                .limit(size)
                .peek(tour->tour.setId(idGenerator.getAndIncrement()))
                .collect(Collectors.toList());
    }

    /*найти тур по его id*/
    public Optional<Tour> getById(Integer id) {
        return availableTours.stream()
                .filter(tour->tour.getId() == id)
                .findFirst();
    }
}
