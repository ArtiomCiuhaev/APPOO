package com.travel.agency.controller;

import com.travel.agency.Entity.SearchTourParametersDTO;
import com.travel.agency.Entity.Tour;
import com.travel.agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TourController {
    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    //вывод списка всех туров
    @RequestMapping(value = "/tours", method = RequestMethod.GET)
    public ModelAndView tours(ModelAndView modelAndView) {
        List<Tour> allTours = tourService.findAll();
        modelAndView.addObject("tours", allTours);
        modelAndView.setViewName("/tours/all");

        return modelAndView;
    }

    //вывод детальной информации о туре
    @RequestMapping(value = "/tours/{id}", method = RequestMethod.GET)
    public ModelAndView tourDetail(ModelAndView modelAndView,
                                   @PathVariable("id") Integer id,
                                   @RequestParam(value = "bookTour", required = false) boolean bookTour,
                                   @RequestParam(value = "showError", required = false) boolean showError,
                                   @Valid @ModelAttribute("orderDTO") OrderDTO orderDTO,
                                   BindingResult bindingResult
                                   ) {
        Optional<Tour> tour = tourService.getById(id);
       /* if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }*/
        if (tour.isPresent()) {
            modelAndView.addObject("tour", tour.get());
            modelAndView.addObject("bookTour", bookTour);
            modelAndView.addObject("showError", showError);
            orderDTO.setTourID(id);
            modelAndView.addObject("orderDTO", orderDTO);

            modelAndView.setViewName("/tours/details");
        } else {
            modelAndView.addObject("tourId", id);
            modelAndView.setViewName("/tours/missing");
        }

        return modelAndView;
    }

    //для страницы поиска (ввод параметров)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchTours(ModelAndView modelAndView) {
        modelAndView.addObject("params", new SearchTourParametersDTO());
        modelAndView.setViewName("/search");
        return modelAndView;
    }

    //обработка параметров поиска и вывод результата
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchResults(ModelAndView modelAndView,
                                      @ModelAttribute("params")SearchTourParametersDTO params) {
        List<Tour> tours = tourService.search(params);

        modelAndView.addObject("notFound", tours.isEmpty());
        modelAndView.addObject("tours", tours);
        modelAndView.addObject("itemId", -1);
        modelAndView.setViewName("/tours/all");
        return modelAndView;
    }
}
