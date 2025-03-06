package com.example.locate.controller;

import com.example.locate.model.Store;
import com.example.locate.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Marks this class as a Spring MVC Controller and sets the base request mapping to "/stores".
@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    // Constructor-based dependency injection of StoreService.
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // Handles GET request to "/stores", retrieves all stores, and displays them in "store-list" view.
    @GetMapping
    public String listStores(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "store-list";
    }

    // Handles GET request to "/stores/add", initializes an empty Store object, and loads "store-form" view for adding a new store.
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("store", new Store());
        return "store-form";
    }

    // Handles GET request to "/stores/edit/{id}", retrieves a store by ID, and loads "store-form" view for editing.
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Store store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "store-form";
    }

    // Handles POST request to "/stores/save", saves or updates a store, then redirects back to the store list.
    @PostMapping("/save")
    public String saveStore(@ModelAttribute Store store) {
        storeService.addStore(store);
        return "redirect:/stores";
    }

    // Handles GET request to "/stores/delete/{id}", deletes a store by ID, and redirects back to the store list.
    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return "redirect:/stores";
    }
}
