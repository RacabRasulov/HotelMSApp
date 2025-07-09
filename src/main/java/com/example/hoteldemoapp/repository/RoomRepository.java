package com.example.hoteldemoapp.repository;

import com.example.hoteldemoapp.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity,Long> {
}
