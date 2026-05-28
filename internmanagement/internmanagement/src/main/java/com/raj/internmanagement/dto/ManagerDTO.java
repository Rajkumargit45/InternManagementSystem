package com.raj.internmanagement.dto;

public class ManagerDTO {
    private Long managerId;
    private String name;
    private String department;

    // Constructor
    public ManagerDTO(Long managerId, String name, String department) {
        this.managerId = managerId;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
