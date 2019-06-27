package com.web.main.service;

import com.web.main.model.Item;
import com.web.main.model.Pedido;
import com.web.main.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private PratoService pratoService;
    
    @Override
    public void salvarItem(Iterable<Item> items) {
        itemRepository.saveAll(items);
    }
    
    @Override
    public List<Item> buscarPedido(Pedido pedido) {
        return itemRepository.findByPedido(pedido);
    }
    
}
