package com.springBoot.login.controller;

import com.springBoot.login.model.User;
import com.springBoot.login.service.SecurityService;
import com.springBoot.login.service.UserService;
import com.springBoot.login.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("registration").addObject("userForm", new User());
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return new ModelAndView("welcome").addObject("message", "Registration successful!");
    }

    @GetMapping("/login")
    public ModelAndView login(String error, String logout) {
        ModelAndView modelAndView = new ModelAndView("login");

        if (error != null) {
            modelAndView.addObject("error", error);
        }

        if (logout != null)
            return modelAndView.addObject("message", "You have been logged out successfully.");

        return modelAndView;
    }

    @GetMapping({"/", "/welcome"})
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }
}
