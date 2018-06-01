package com.travel.agency.repository;

import com.travel.agency.Entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository {
    List<Tour> findAll();
    Optional<Tour> getById(Integer id);
}
