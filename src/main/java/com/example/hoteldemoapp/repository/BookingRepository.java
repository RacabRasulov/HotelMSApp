package com.example.hoteldemoapp.repository;

import com.example.hoteldemoapp.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity,Long> {
}
