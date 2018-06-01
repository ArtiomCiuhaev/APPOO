package com.travel.agency.service;

import com.travel.agency.Entity.SearchTourParametersDTO;
import com.travel.agency.Entity.Tour;
import com.travel.agency.repository.TourRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*сервис для доступа к турам*/
@Service
public class TourServiceImpl implements TourService {
    private final TourRepositoryImpl tourRepository;

    @Autowired
    public TourServiceImpl(TourRepositoryImpl tourRepository) {
        this.tourRepository = tourRepository;
    }


    /*получить все туры*/
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    /*получить тур по его id*/
    public Optional<Tour> getById(Integer id) {
        return tourRepository.getById(id);
    }

    /*найти туры, которые отвечают заданным критериям*/
    @Override
    public List<Tour> search(SearchTourParametersDTO params) {
        List<Tour> tours = tourRepository.findAll();

        return tours.stream()
                .filter(tour -> {
                    if (params.getTitle() != null && !params.getTitle().isEmpty()) {
                        return tour.getTitle().contains(params.getTitle());
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.getAddress() != null && !params.getAddress().isEmpty()) {
                        return tour.getHotel().getAddress().contains(params.getAddress());
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.isOnlyHot()) {
                        return tour.isHot();
                    } else {
                        return true;
                    }
                })
                .filter(tour -> {
                    if (params.getDateLow() != null) {
                        return params.getDateLow().isBefore(tour.getDateFrom());
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.getDateUp() != null) {
                        return params.getDateUp().isAfter(tour.getDateFrom());
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.getTransport()!= null && !params.getTransport().isEmpty()) {
                        return tour.getTransport().toString().contains(params.getTransport());
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.getStarLow() != null && params.getStarLow() != 0) {
                        return tour.getHotel().getStar() >= params.getStarLow();
                    }
                    return true;
                })
                .filter(tour -> {
                    if (params.getStarUp() != null && params.getStarUp() != 0) {
                        return tour.getHotel().getStar() <= params.getStarUp();
                    }
                    return true;
                })
                .collect(Collectors.toList());

    }
}
