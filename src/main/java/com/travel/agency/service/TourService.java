package com.travel.agency.service;

import com.travel.agency.Entity.SearchTourParametersDTO;
import com.travel.agency.Entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> findAll();
    Optional<Tour> getById(Integer id);

    List<Tour> search(SearchTourParametersDTO params);
}
