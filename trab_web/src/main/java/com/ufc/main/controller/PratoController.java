package com.ufc.main.controller;

import com.ufc.main.model.Prato;
import com.ufc.main.service.PratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PratoController {

     @Autowired
     private PratoService pratoService;

     @RequestMapping("/listar")
     public ModelAndView listarPratos() {
          List<Prato> pratos = pratoService.listar();
          ModelAndView mv = new ModelAndView("ListaPrato");
          mv.addObject("listaPratos", pratos);
          return mv;
     }

     @RequestMapping("/novo")
     public ModelAndView novoPrato() {
          ModelAndView mv = new ModelAndView("NovoPrato");
          mv.addObject("prato", new Prato());
          return mv;
     }

     @RequestMapping("/salvar")
     public ModelAndView salvarPrato(@Validated Prato prato) {
          pratoService.salvar(prato);
          ModelAndView mv = new ModelAndView("redirect:/admin/listar");
          return mv;
     }

     @RequestMapping("/editar/{cod}")
     public ModelAndView editarPrato(@PathVariable Integer cod) {
          Prato prato = pratoService.buscar(cod);
          ModelAndView mv = new ModelAndView("EditarPrato");
          mv.addObject("prato", prato);
          return mv;
     }

     @RequestMapping("/deletar/{cod}")
     public ModelAndView deletarPrato(@PathVariable Integer cod) {
          pratoService.deletar(cod);
          ModelAndView mv = new ModelAndView("redirect:/admin/listar");
          return mv;
     }

}
