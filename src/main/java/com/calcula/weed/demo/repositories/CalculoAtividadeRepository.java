package com.calcula.weed.demo.repositories;

import com.calcula.weed.demo.entities.CalculoAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoAtividadeRepository extends JpaRepository<CalculoAtividade, Long> {


}
