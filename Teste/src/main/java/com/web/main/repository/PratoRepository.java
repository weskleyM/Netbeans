package com.web.main.repository;

import com.web.main.model.Prato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

    List<Prato> findByStatus(int status);
}
