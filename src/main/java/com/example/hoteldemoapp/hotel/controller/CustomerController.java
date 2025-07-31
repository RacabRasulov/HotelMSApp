package com.example.hoteldemoapp.hotel.controller;

import com.example.hoteldemoapp.hotel.dto.request.customer.CreateCustomerDtoRequest;
import com.example.hoteldemoapp.hotel.dto.request.customer.UpdateCustomerDtoRequest;
import com.example.hoteldemoapp.hotel.dto.response.customer.DeleteCustomerDtoResponse;
import com.example.hoteldemoapp.hotel.dto.response.customer.GetAllCustomerDtoResponse;
import com.example.hoteldemoapp.hotel.dto.response.customer.GetByIdCustomerDtoResponse;
import com.example.hoteldemoapp.hotel.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCustomerDtoRequest dtoRequest) {

        service.save(dtoRequest);
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomerDtoResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdCustomerDtoResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeleteCustomerDtoResponse delete(@PathVariable Long id) {

        return service.delete(id);

    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateCustomerDtoRequest request, @PathVariable Long id) {
        service.update(request, id);

    }


}
