package com.raj.internmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "intern")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intern_id")
    private Long internId;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnoreProperties("interns")  // Prevents recursion by ignoring manager's interns list during serialization
    private Manager manager;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}