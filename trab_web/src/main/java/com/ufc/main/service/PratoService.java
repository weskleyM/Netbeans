package com.ufc.main.service;

import com.ufc.main.model.Prato;
import com.ufc.main.repository.PratoRepository;
import com.ufc.main.util.AppFileUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PratoService {
     
     @Autowired
     public PratoRepository pratoRepository;
     
     public List<Prato> listar() {
          return pratoRepository.findAll();
     }
     
     public void salvar(Prato prato, MultipartFile imagem) {
          String caminho = "images/" + prato.getNome() + ".png";
          AppFileUtils.salvarImagem(caminho, imagem);
          pratoRepository.save(prato);
     }
     
     public Prato buscar(Integer cod) {
          return pratoRepository.getOne(cod);
     }
     
     public void deletar(Integer cod) {
          pratoRepository.deleteById(cod);
     }
     
}
