package com.example.hoteldemoapp.hotel.service;

import com.example.hoteldemoapp.hotel.dto.request.customer.CreateCustomerDtoRequest;
import com.example.hoteldemoapp.hotel.dto.request.customer.UpdateCustomerDtoRequest;

import com.example.hoteldemoapp.hotel.dto.response.customer.*;
import com.example.hoteldemoapp.hotel.entity.CustomerEntity;
import com.example.hoteldemoapp.hotel.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {


    private final CustomerRepository customerRepository;
    // private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        // this.modelMapper = modelMapper;
    }

    public CreateCustomerDtoResponse save(CreateCustomerDtoRequest dtoRequest) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(dtoRequest.getName());
        customerEntity.setSurname(dtoRequest.getSurname());
        customerEntity.setPhone(dtoRequest.getPhone());
        customerEntity.setPassportSeriesAndNumber(dtoRequest.getPassportSeriesAndNumber());

        CustomerEntity saveEntity = customerRepository.save(customerEntity);

        CreateCustomerDtoResponse response = new CreateCustomerDtoResponse();
        response.setId(saveEntity.getId());
        response.setName(saveEntity.getName());
        response.setSurname(saveEntity.getSurname());
        response.setPhone(saveEntity.getPhone());
        response.setPassportSeriesAndNumber(saveEntity.getPassportSeriesAndNumber());
        return response;

    }


    public List<GetAllCustomerDtoResponse> getAll() {
        List<CustomerEntity> entitiesList = customerRepository.findAll();
        List<GetAllCustomerDtoResponse> responseList = new ArrayList<>();

        for (CustomerEntity customer : entitiesList
        ) {
            GetAllCustomerDtoResponse response = new GetAllCustomerDtoResponse();

            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setSurname(customer.getSurname());
            response.setPhone(customer.getPhone());
            response.setPassportSeriesAndNumber(customer.getPassportSeriesAndNumber());
            responseList.add(response);
        }

        return responseList;
    }


    public GetByIdCustomerDtoResponse getById(Long id) {

        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);

        if (optionalCustomerEntity.isEmpty()) {
            throw new RuntimeException("Müştəri tapılmadı: İD = " + id);

        }

        CustomerEntity entity = optionalCustomerEntity.get();

        GetByIdCustomerDtoResponse response = new GetByIdCustomerDtoResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setPhone(entity.getPhone());
        response.setPassportSeriesAndNumber(entity.getPassportSeriesAndNumber());

        return response;
    }


    public DeleteCustomerDtoResponse delete(Long id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);

        if (optionalCustomerEntity.isEmpty()) {
            throw new RuntimeException("Müştəri tapılmadı: ID = " + id);
        }
        CustomerEntity entity = optionalCustomerEntity.get();
        DeleteCustomerDtoResponse response = new DeleteCustomerDtoResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setPhone(entity.getPhone());
        response.setPassportSeriesAndNumber(entity.getPassportSeriesAndNumber());

        customerRepository.deleteById(id);
        return response;
    }

    public UpdateCustomerDtoResponse update(UpdateCustomerDtoRequest dtoRequest, Long id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("Müştəri tapılmadı:ID = " + dtoRequest.getId());
        }

        CustomerEntity entity = optionalCustomer.get();
        entity.setName(dtoRequest.getName());
        entity.setSurname(dtoRequest.getSurname());
        entity.setPhone(dtoRequest.getPhone());
        entity.setPassportSeriesAndNumber(dtoRequest.getPassportSeriesAndNumber());

        CustomerEntity updateEntity = customerRepository.save(entity);
        UpdateCustomerDtoResponse responseDto = new UpdateCustomerDtoResponse();
        responseDto.setId(updateEntity.getId());
        responseDto.setName(updateEntity.getName());
        responseDto.setSurname(updateEntity.getSurname());
        responseDto.setPhone(updateEntity.getPhone());
        responseDto.setPassportSeriesAndNumber(updateEntity.getPassportSeriesAndNumber());

        return responseDto;


    }

}


