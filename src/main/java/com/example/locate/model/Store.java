package com.example.locate.model;

import jakarta.persistence.*;

//Marks this class as a JPA entity and maps it to the "stores" table.
@Entity
@Table(name = "stores")
public class Store {

 // Primary key with auto-incremented ID.
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 // Column to store the name of the store.
 @Column(name = "name")
 private String name;

 // Column to store the phone number of the store.
 @Column(name = "phone_number")
 private String phoneNumber;

 // Column to store localities as a comma-separated string.
 @Column(name = "localities")
 private String localities;

 // Default constructor required by JPA.
 public Store() {
 }

 // Constructor to initialize all fields, ensuring localities are stored as a clean CSV string.
 public Store(Long id, String name, String phoneNumber, String[] localities) {
     this.id = id;
     this.name = name;
     this.phoneNumber = phoneNumber;
     this.localities = String.join(",", localities) // Join array elements into a single CSV string
                             .replace("[", "") // Remove unwanted brackets
                             .replace("]", "");
 }

 // Getter and setter methods for all fields.

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 // Returns localities as a formatted string, ensuring an empty value if null.
 public String getLocalities() {
     return (localities == null || localities.isEmpty()) ? "" : localities;
 }

 // Sets the localities directly as a comma-separated string.
 public void setLocalities(String localities) {
     this.localities = localities;
 }

 // Returns a string representation of the Store object.
 @Override
 public String toString() {
     return "Store{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", phoneNumber='" + phoneNumber + '\'' +
             ", localities=" + localities +
             '}';
 }
}
