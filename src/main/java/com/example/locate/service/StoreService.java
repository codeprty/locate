package com.example.locate.service;

import com.example.locate.repository.StoreDAO;
import com.example.locate.model.Store;
import org.springframework.stereotype.Service;
import java.util.List;

// Marks this class as a service component for business logic.
@Service
public class StoreService {

    // Dependency on StoreDAO for data operations.
    private final StoreDAO storeDAO;

    // Constructor-based dependency injection for StoreDAO.
    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }
    
    // Saves a new store or updates an existing store in the database.
    public void addStore(Store store) {
        storeDAO.save(store);
    }

    // Retrieves a list of all stores from the database.
    public List<Store> getAllStores() {
        return storeDAO.findAll();
    }

    // Fetches a specific store by its ID, returns null if not found.
    public Store getStoreById(Long id) {
        return storeDAO.findById(id).orElse(null);
    }

    // Updates an existing store's details if found.
    public Store updateStore(Long id, Store storeDetails) {
        return storeDAO.findById(id).map(store -> {
            store.setName(storeDetails.getName());
            store.setPhoneNumber(storeDetails.getPhoneNumber());
            store.setLocalities(storeDetails.getLocalities());
            return storeDAO.save(store); // Saves the updated store
        }).orElse(null); // Returns null if store not found
    }

    // Deletes a store by its ID.
    public void deleteStore(Long id) {
        storeDAO.deleteById(id);
    }
}
