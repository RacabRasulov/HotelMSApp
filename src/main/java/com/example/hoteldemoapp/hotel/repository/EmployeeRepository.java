package com.example.hoteldemoapp.hotel.repository;

import com.example.hoteldemoapp.hotel.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long > {
}
