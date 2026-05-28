package com.raj.internmanagement.dto;

public class InternDTO {
    private Long internId;
    private String name;
    private String email;

    // Constructor
    public InternDTO(Long internId, String name, String email) {
        this.internId = internId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getInternId() {
        return internId;
    }

    public void setInternId(Long internId) {
        this.internId = internId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
