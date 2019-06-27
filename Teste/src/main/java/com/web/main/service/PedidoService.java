package com.web.main.service;

import com.web.main.model.Pedido;
import com.web.main.model.User;
import java.util.List;

public interface PedidoService {

    public void salvarPedido(Pedido pedido);

    public List<Pedido> buscarUser(User user);

    public Pedido findById(Integer id);

    public List<Pedido> findAll();
}
