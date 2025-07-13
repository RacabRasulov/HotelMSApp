package com.example.hoteldemoapp.controller;

import com.example.hoteldemoapp.dto.request.minibar.CreateMiniBarItemDtoRequest;
import com.example.hoteldemoapp.dto.response.minibar.CreateMiniBarItemDtoResponse;
import com.example.hoteldemoapp.service.MiniBarItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/miniBarItem")
public class MiniBarItemController {

public final MiniBarItemService service;


    public MiniBarItemController(MiniBarItemService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMiniBarItemDtoResponse add( @RequestBody @Valid CreateMiniBarItemDtoRequest dtoRequest){

        return service.save(dtoRequest);


    }




}
