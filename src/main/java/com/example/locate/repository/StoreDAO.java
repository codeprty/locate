package com.example.locate.repository;

import com.example.locate.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Marks this interface as a repository component, allowing Spring to manage it as a data access layer.
@Repository
public interface StoreDAO extends JpaRepository<Store, Long> {
	
}
