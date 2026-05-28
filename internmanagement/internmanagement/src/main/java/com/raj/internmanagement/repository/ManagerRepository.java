package com.raj.internmanagement.repository;

import com.raj.internmanagement.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
