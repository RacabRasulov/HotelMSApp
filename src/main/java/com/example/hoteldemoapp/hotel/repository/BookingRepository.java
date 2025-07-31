package com.example.hoteldemoapp.hotel.repository;

import com.example.hoteldemoapp.hotel.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity,Long> {
}
