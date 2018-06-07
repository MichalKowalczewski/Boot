package com.learning.boot.controller;

import com.learning.boot.model.PortalUser;
import com.learning.boot.service.PortalUserService;
import com.learning.boot.service.SecurityService;
import com.learning.boot.util.PortalUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PortalUserController {
    @Autowired
    private PortalUserService portalUserService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    PortalUserValidator portalUserValidator;

    @ModelAttribute("user")
    public PortalUser getPortalUserObject() {
        return new PortalUser();
    }

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PortalUser portalUser = portalUserService.findByLogin(user.getUsername());
        int id = portalUser.getPortalUserID();
        String login = portalUser.getPortalUserLogin();
        String firstName = portalUser.getPortalUserFirstName();
        String lastName = portalUser.getPortalUserLastName();
        String email = portalUser.getPortalUserEmail();

        model.addAttribute("id", id);
        model.addAttribute("login", login);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        return "details";
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String update(@ModelAttribute("portalUser") PortalUser user, BindingResult bindingResult, Model model) {
        System.out.println("sprawdzam wartość" + user.getPortalUserID());

        portalUserValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "details";
        }

        portalUserService.save(user);


        return "details";
    }

    @GetMapping("/access-denied")
    public String error403() {
        return "/error/access-denied";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}


