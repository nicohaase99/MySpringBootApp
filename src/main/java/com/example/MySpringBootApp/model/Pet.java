package com.example.MySpringBootApp.model;

public class Pet {

    private Long id;
    private String name;
    private String type;
    private int age;
    private Long ownerId;

    // Constructors
    public Pet() {}

    public Pet(Long id, String name, String type, int age, Long ownerId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.ownerId = ownerId;
    }

    // Getters and Setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
