package com.example.hoteldemoapp.repository;

import com.example.hoteldemoapp.entity.MiniBarItemEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinibarItemRepository extends JpaRepository<MiniBarItemEntity, Id> {
}
