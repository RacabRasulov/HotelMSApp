package com.example.hoteldemoapp.repository;

import com.example.hoteldemoapp.dto.response.customer.DeleteCustomerDtoResponse;
import com.example.hoteldemoapp.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {


}
