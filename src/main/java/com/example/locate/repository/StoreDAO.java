package com.example.locate.repository;

import com.example.locate.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Marks this interface as a Spring-managed repository for data access.
@Repository
public interface StoreDAO extends JpaRepository<Store, Long> {
	
}
