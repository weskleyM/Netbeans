package com.web.main.repository;

import com.web.main.model.Pedido;
import com.web.main.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByUserOrderByDatePedido(User user);
}
