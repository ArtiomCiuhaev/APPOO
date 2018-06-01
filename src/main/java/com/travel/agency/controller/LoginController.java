package com.travel.agency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class LoginController {
    /*маппинг на страницу логина*/
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /*после успешной авторизации*/
    @RequestMapping("/authorized")
    public ModelAndView authorized(Authentication authentication) {
        String login = authentication.getName();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/orders")
                .build()
                .expand(login)
                .encode();
        RedirectView redirectView = new RedirectView(uriComponents.toUriString(), true, true, false);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        modelAndView.setStatus(HttpStatus.PERMANENT_REDIRECT);
        return modelAndView;
    }

}
