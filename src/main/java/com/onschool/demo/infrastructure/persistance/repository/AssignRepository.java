package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.Assign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssignRepository extends JpaRepository<Assign, Long> {

}
