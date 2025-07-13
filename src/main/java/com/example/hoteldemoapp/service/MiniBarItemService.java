package com.example.hoteldemoapp.service;

import com.example.hoteldemoapp.dto.request.minibar.CreateMiniBarItemDtoRequest;
import com.example.hoteldemoapp.dto.response.minibar.CreateMiniBarItemDtoResponse;
import com.example.hoteldemoapp.entity.MiniBarItemEntity;
import com.example.hoteldemoapp.repository.MinibarItemRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniBarItemService {

    private final MinibarItemRepository repository;

    public MiniBarItemService(MinibarItemRepository repository) {
        this.repository = repository;
    }

    public CreateMiniBarItemDtoResponse save(CreateMiniBarItemDtoRequest dtoRequest) {
        MiniBarItemEntity entity = new MiniBarItemEntity();
        entity.setName(dtoRequest.getName());
        entity.setNote(dtoRequest.getNote());
        entity.setSalePrice(dtoRequest.getSalePrice());

        repository.save(entity);

        CreateMiniBarItemDtoResponse response = new CreateMiniBarItemDtoResponse();

        response.setName(entity.getName());
        response.setNote(entity.getNote());
        response.setSalePrice(entity.getSalePrice());
        response.setAveragePurchasePrice(entity.getAveragePurchasePrice());

        return response;

    }


}
