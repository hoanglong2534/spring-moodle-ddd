package com.onschool.demo.infrastructure.persistance.repository;

import com.onschool.demo.infrastructure.persistance.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Modules, Long> {

}
