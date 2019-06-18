package com.ufc.main.controller;

import com.ufc.main.model.Prato;
import com.ufc.main.service.PratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PratoController {

     @Autowired
     private PratoService service;

     @RequestMapping("/cadastrar")
     public ModelAndView cadastrarPrato() {
          ModelAndView mv = new ModelAndView("cadastrar");
          mv.addObject("prato", new Prato());
          return mv;
     }

     @RequestMapping("/salvar")
     public ModelAndView salvarPrato(@Validated Prato prato, BindingResult result, @RequestParam(value = "imagem") MultipartFile imagem) {
          ModelAndView mv = new ModelAndView("cadastrar");
          if (result.hasErrors()) {
               return mv;
          }
          service.salvar(prato, imagem);
          mv.addObject("mensagem", "Prato salvo com  sucesso!");
          return mv;
     }

     @RequestMapping("/listar")
     public ModelAndView listarPrato() {
          ModelAndView mv = new ModelAndView("listar");
          List<Prato> pratos = service.listar();
          mv.addObject("listaDePratos", pratos);
          return mv;
     }

     @RequestMapping("/deletar/{id}")
     public ModelAndView deletarPrato(@PathVariable(name = "id") Long id) {
          ModelAndView mv = new ModelAndView("redirect:/admin/listar");
          service.deletar(id);
          return mv;
     }

     @RequestMapping("/editar/{id}")
     public ModelAndView editarPrato(@PathVariable(name = "id") Long id) {
          ModelAndView mv = new ModelAndView("editar");
          Prato prato = service.buscar(id);
          mv.addObject("prato", prato);
          return mv;
     }
}
