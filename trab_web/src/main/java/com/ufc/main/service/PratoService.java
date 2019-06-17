package com.ufc.main.service;

import com.ufc.main.model.Prato;
import com.ufc.main.repository.PratoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PratoService {

     @Autowired
     public PratoRepository pratoRepository;

     public List<Prato> listar() {
          return pratoRepository.findAll();
     }

     public void salvar(Prato prato) {
          pratoRepository.save(prato);
     }

     public Prato buscar(Integer cod) {
          return pratoRepository.getOne(cod);
     }

     public void deletar(Integer cod) {
          pratoRepository.deleteById(cod);
     }

}
