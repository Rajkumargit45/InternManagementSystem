package com.raj.internmanagement.repository;
import com.raj.internmanagement.Model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface InternRepository extends JpaRepository<Intern, Long> {
}
