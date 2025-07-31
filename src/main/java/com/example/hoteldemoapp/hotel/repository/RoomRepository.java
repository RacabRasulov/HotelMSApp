package com.example.hoteldemoapp.hotel.repository;

import com.example.hoteldemoapp.hotel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity,Long> {
}
