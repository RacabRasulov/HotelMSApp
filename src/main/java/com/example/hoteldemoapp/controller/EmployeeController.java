package com.example.hoteldemoapp.controller;

import com.example.hoteldemoapp.dto.request.employee.CreateEmployeeDtoRequest;
import com.example.hoteldemoapp.dto.request.employee.UpdateEmployeeDtoRequest;
import com.example.hoteldemoapp.dto.response.employee.DeleteEmployeeDtoResponse;
import com.example.hoteldemoapp.dto.response.employee.GetAllEmployeeDtoResponse;
import com.example.hoteldemoapp.dto.response.employee.GetByIdEmployeeDtoResponse;
import com.example.hoteldemoapp.dto.response.employee.UpdateEmployeeDtoResponse;
import com.example.hoteldemoapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateEmployeeDtoRequest dtoRequest) {
        service.save(dtoRequest);

    }


    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdEmployeeDtoResponse getById(@PathVariable Long id) {
        return service.getById(id);

    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllEmployeeDtoResponse> getAll() {

        return service.getAll();
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeleteEmployeeDtoResponse delete(@PathVariable Long id) {

        return service.delete(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateEmployeeDtoResponse update(@RequestBody  UpdateEmployeeDtoRequest dtoRequest,@PathVariable Long id) {
        return service.update(dtoRequest, id);

    }
}
