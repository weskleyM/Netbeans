package com.ufc.main.service;

import com.ufc.main.model.Prato;
import com.ufc.main.repository.PratoRepository;
import com.ufc.main.util.ImgFileUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PratoService {

     @Autowired
     private PratoRepository repo;

     public void salvar(Prato prato, MultipartFile imagem) {
          String local = "images/" + prato.getNome() + ".png";
          ImgFileUtils.salvarImagem(local, imagem);
          repo.save(prato);
     }

     public List<Prato> listar() {
          return repo.findAll();
     }

     public void deletar(Long id) {
          repo.deleteById(id);
     }

     public Prato buscar(Long id) {
          return repo.getOne(id);
     }
}
