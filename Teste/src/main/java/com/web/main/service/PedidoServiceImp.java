package com.web.main.service;

import com.web.main.model.Pedido;
import com.web.main.model.User;
import com.web.main.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImp implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> buscarUser(User user) {
        return pedidoRepository.findByUserOrderByDatePedido(user);
    }

    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.getOne(id);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

}
