package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.Assign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignRepository extends JpaRepository<Assign, Long> {

}
