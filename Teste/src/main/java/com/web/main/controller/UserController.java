package com.web.main.controller;

import com.web.main.model.User;
import com.web.main.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/templates/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registro"); // resources/templates/registro.html
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/templates/home.html
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin"); // resources/templates/admin.html
        return modelAndView;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        // Checa a validação dos campos
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("msg", "Há erros no fomulário!");
            modelMap.addAttribute("bindingResult", bindingResult);
        } else if (userService.userJaExiste(user)) {
            modelAndView.addObject("msg", "Usuário já existe!");
        } // Salva se nçao houver erros
        else {
            userService.saveUser(user);
            modelAndView.addObject("msg", "Usuário cadastrado com sucesso!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registro"); // resources/templates/registro.html
        return modelAndView;
    }
}
