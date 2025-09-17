package com.example.MySpringBootApp.model;

public class Appointment {

    private Long id;
    private Long petId;
    private long ownerId;
    private String date;

    // Constructors
    public Appointment() {}

    public Appointment(Long id, Long petId, long ownerId, String date) {
        this.id = id;
        this.petId = petId;
        this.ownerId = ownerId;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPetId() {
        return petId;
    }
    public void setPetId(Long petId) {
        this.petId = petId;
    }
    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
