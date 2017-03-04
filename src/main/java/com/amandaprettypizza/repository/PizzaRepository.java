package com.amandaprettypizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amandaprettypizza.domain.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
