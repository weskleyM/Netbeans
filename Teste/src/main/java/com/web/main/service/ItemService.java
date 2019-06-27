package com.web.main.service;

import com.web.main.model.Item;
import com.web.main.model.Pedido;
import java.util.List;

public interface ItemService {

    public void salvarItem(Iterable<Item> items);

    public List<Item> buscarPedido(Pedido pedido);
}
