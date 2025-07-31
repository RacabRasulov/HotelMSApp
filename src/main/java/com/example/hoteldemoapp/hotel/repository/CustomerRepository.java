package com.example.hoteldemoapp.hotel.repository;

import com.example.hoteldemoapp.hotel.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {


}
