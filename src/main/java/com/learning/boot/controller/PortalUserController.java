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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("newUser", new PortalUser());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("newUser") PortalUser newUser, BindingResult bindingResult, Model model) {
        portalUserValidator.validate(newUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        portalUserService.save(newUser);

        securityService.autologin(newUser.getPortalUserLogin(), newUser.getPortalUserPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or Password invalid");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PortalUser portalUser = portalUserService.findByLogin(user.getUsername());
        String login = portalUser.getPortalUserLogin();
        String firstName = portalUser.getPortalUserFirstName();
        String lastName = portalUser.getPortalUserLastName();
        String email = portalUser.getPortalUserEmail();

        model.addAttribute("login", login);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        return "details";
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") PortalUser user, BindingResult bindingResult, Model model) {
        User testuser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PortalUser portalUser = portalUserService.findByLogin(testuser.getUsername());

        portalUserValidator.validate(portalUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "details";
        }

        portalUserService.save(portalUser);


        return "details";
    }
}


