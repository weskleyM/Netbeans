package com.ufc.main.controller;

import com.ufc.main.model.Prato;
import com.ufc.main.service.PratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PratoController {

     @Autowired
     private PratoService pratoService;

     @GetMapping("/listar")
     public ModelAndView listarPratos() {
          List<Prato> pratos = pratoService.listar();
          ModelAndView mv = new ModelAndView("ListaPrato");
          mv.addObject("listaPratos", pratos);
          return mv;
     }
}
