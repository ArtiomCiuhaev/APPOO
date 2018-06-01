package com.travel.agency.controller;

import com.travel.agency.Entity.Order;
import com.travel.agency.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //страница со всеми заказами
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView allOrder(ModelAndView modelAndView) {
        List<Order> orders = orderService.findAll();
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders/all");

        return modelAndView;
    }

    //прием пост-запроса с данными о заказе
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView addOrder(ModelAndView modelAndView,
                                 @Valid @ModelAttribute("orderDTO") OrderDTO orderDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .path("/tours/{id}")
                    .query("bookTour={bookTour}")
                    .query("showError=true")
                    .build()
                    .expand(orderDTO.getTourID(), true)
                    .encode();
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            RedirectView view = new RedirectView(uriComponents.toUriString(), true, true, false);
            view.addStaticAttribute("orderDTO", orderDTO);
            modelAndView.setView(view);

            return modelAndView;
        }
        orderService.save(orderDTO);
        modelAndView.setViewName("redirect:/tours");
        return modelAndView;
    }
}
