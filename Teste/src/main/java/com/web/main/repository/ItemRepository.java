package com.web.main.repository;

import com.web.main.model.Item;
import com.web.main.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByPedido(Pedido pedido);
}
