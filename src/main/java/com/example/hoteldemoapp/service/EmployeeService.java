package com.example.hoteldemoapp.service;

import com.example.hoteldemoapp.dto.request.employee.CreateEmployeeDtoRequest;
import com.example.hoteldemoapp.dto.request.employee.UpdateEmployeeDtoRequest;
import com.example.hoteldemoapp.dto.response.employee.*;
import com.example.hoteldemoapp.entity.EmployeeEntity;
import com.example.hoteldemoapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void save(CreateEmployeeDtoRequest dtoRequest) {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());
        entity.setName(dtoRequest.getName());
        entity.setSurname(dtoRequest.getSurname());
        entity.setBrithDate(dtoRequest.getBrithDate());
        entity.setPassportSeriesAndNumber(dtoRequest.getPassportSeriesAndNumber());
        entity.setAddress(dtoRequest.getAddress());
        entity.setPosition(dtoRequest.getPosition());
        entity.setSalary(dtoRequest.getSalary());
        entity.setHireDate(dtoRequest.getHireDate());

        EmployeeEntity saveEntity = employeeRepository.save(entity);

        CreateEmployeeDtoResponse response = new CreateEmployeeDtoResponse();

        response.setId(saveEntity.getId());
        response.setName(saveEntity.getName());
        response.setSurname(saveEntity.getSurname());
        response.setBrithDate(dtoRequest.getBrithDate());
        response.setPassportSeriesAndNumber(dtoRequest.getPassportSeriesAndNumber());
        response.setAddress(dtoRequest.getAddress());
        response.setPosition(dtoRequest.getPosition());
        response.setSalary(dtoRequest.getSalary());
        response.setHireDate(dtoRequest.getHireDate());

    }


    public GetByIdEmployeeDtoResponse getById(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

        if (optionalEmployeeEntity.isEmpty()) {

            throw new RuntimeException("Müştəri tapılmadı: İD =:" + id);
        }

        EmployeeEntity entity = optionalEmployeeEntity.get();

        GetByIdEmployeeDtoResponse response = new GetByIdEmployeeDtoResponse();

        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setBrithDate(entity.getBrithDate());
        response.setPosition(entity.getPosition());
        response.setAddress(entity.getAddress());
        response.setSalary(entity.getSalary());
        response.setPassportSeriesAndNumber(entity.getPassportSeriesAndNumber());
        response.setHireDate(entity.getHireDate());

        return response;

    }

    public List<GetAllEmployeeDtoResponse> getAll() {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        List<GetAllEmployeeDtoResponse> dtoResponseList = new ArrayList<>();

        for (EmployeeEntity entity : entityList
        ) {
            GetAllEmployeeDtoResponse response = new GetAllEmployeeDtoResponse();

            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setSurname(entity.getSurname());
            response.setBrithDate(entity.getBrithDate());
            response.setPosition(entity.getPosition());
            response.setPassportSeriesAndNumber(entity.getPassportSeriesAndNumber());
            response.setSalary(entity.getSalary());
            response.setHireDate(entity.getHireDate());
            response.setAddress(entity.getAddress());
            dtoResponseList.add(response);


        }
        return dtoResponseList;

    }

    public DeleteEmployeeDtoResponse delete(Long id) {

        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {

            throw new RuntimeException("Əməkdaş tapılmadı:ID" + id);
        }

        EmployeeEntity entity = optionalEmployee.get();

        DeleteEmployeeDtoResponse dtoResponse = new DeleteEmployeeDtoResponse();
        dtoResponse.setId(entity.getId());
        dtoResponse.setName(entity.getName());
        dtoResponse.setSurname(entity.getSurname());
        dtoResponse.setAddress(entity.getAddress());
        dtoResponse.setBrithDate(entity.getBrithDate());
        dtoResponse.setPosition(entity.getPosition());
        dtoResponse.setPassportSeriesAndNumber(entity.getPassportSeriesAndNumber());
        dtoResponse.setSalary(entity.getSalary());
        dtoResponse.setHireDate(entity.getHireDate());

        employeeRepository.deleteById(id);
        return dtoResponse;

    }


        public UpdateEmployeeDtoResponse update(UpdateEmployeeDtoRequest dtoRequest, Long id) {

            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.
                    findById(id);

            if (optionalEmployeeEntity.isEmpty()) {
                throw new RuntimeException("Əməkdaş tapılmadı:ID" + id);

            }

            EmployeeEntity entity = optionalEmployeeEntity.get();

            entity.setName(dtoRequest.getName());
            entity.setSurname(dtoRequest.getSurname());
            entity.setSalary(dtoRequest.getSalary());
            entity.setHireDate(dtoRequest.getHireDate());
            entity.setPosition(dtoRequest.getPosition());
            entity.setBrithDate(dtoRequest.getBrithDate());
            entity.setPassportSeriesAndNumber(dtoRequest.getPassportSeriesAndNumber());
            entity.setAddress(dtoRequest.getAddress());


            EmployeeEntity updateEntity = employeeRepository.save(entity);

            UpdateEmployeeDtoResponse dtoResponse = new UpdateEmployeeDtoResponse();

            dtoResponse.setName(updateEntity.getName());
            dtoResponse.setSurname(updateEntity.getSurname());
            dtoResponse.setSalary(updateEntity.getSalary());
            dtoResponse.setHireDate(updateEntity.getHireDate());
            dtoResponse.setPosition(updateEntity.getPosition());
            dtoResponse.setBrithDate(updateEntity.getBrithDate());
            dtoResponse.setPassportSeriesAndNumber(updateEntity.getPassportSeriesAndNumber());
            dtoResponse.setAddress(updateEntity.getAddress());


            return dtoResponse;


        }


}
