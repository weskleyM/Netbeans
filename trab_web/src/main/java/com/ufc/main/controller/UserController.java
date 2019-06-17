package com.ufc.main.controller;

import com.ufc.main.model.User;
import com.ufc.main.service.UserService;
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
     private UserService userService;

     @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
     public ModelAndView login() {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("Login");
          return modelAndView;
     }

     @RequestMapping(value = "/registrar", method = RequestMethod.GET)
     public ModelAndView register() {
          ModelAndView modelAndView = new ModelAndView();
          User user = new User();
          modelAndView.addObject("user", user);
          modelAndView.setViewName("Registrar");
          return modelAndView;
     }

     @RequestMapping(value = "/home", method = RequestMethod.GET)
     public ModelAndView home() {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("Home");
          return modelAndView;
     }

     @RequestMapping(value = "/admin", method = RequestMethod.GET)
     public ModelAndView adminHome() {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("Admin");
          return modelAndView;
     }

     @RequestMapping(value = "/registrar", method = RequestMethod.POST)
     public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
          ModelAndView modelAndView = new ModelAndView();
          // Checa a validação
          if (bindingResult.hasErrors()) {
               modelAndView.addObject("mensagem", "Corrija os erros encontrados");
               modelMap.addAttribute("bindingResult", bindingResult);
          } else if (userService.isUserAlreadyPresent(user)) {
               modelAndView.addObject("mensagem", "Usuário já existe!");
          } // Salva usuario
          else {
               userService.saveUser(user);
               modelAndView.addObject("mensagem", "Usuário registrado com sucesso!");
          }
          modelAndView.addObject("user", new User());
          modelAndView.setViewName("Registrar");
          return modelAndView;
     }
}
