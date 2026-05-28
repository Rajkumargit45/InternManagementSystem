package com.raj.internmanagement.Service;

import com.raj.internmanagement.Model.Intern;
import com.raj.internmanagement.Model.Manager;
import com.raj.internmanagement.dto.InternDTO;
import com.raj.internmanagement.repository.InternRepository;
import com.raj.internmanagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternService {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    public Intern createIntern(Intern intern) {
        return internRepository.save(intern);
    }

    public Intern updateIntern(Long id, Intern updated) {
        Intern existing = internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found with id " + id));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        return internRepository.save(existing);
    }

    public void deleteIntern(Long id) {
        internRepository.deleteById(id);
    }

    public Intern assignManager(Long internId, Long managerId) {
        Intern intern = internRepository.findById(internId)
                .orElseThrow(() -> new RuntimeException("Intern not found with id " + internId));
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Manager not found with id " + managerId));
        intern.setManager(manager);
        return internRepository.save(intern);
    }

    public Intern getInternById(Long id) {
        return internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found with id " + id));
    }

    // New method for DTOs
    public List<InternDTO> getInternDTOList() {
        return internRepository.findAll()
                .stream()
                .map(intern -> new InternDTO(
                        intern.getInternId(),
                        intern.getName(),
                        intern.getEmail()
                ))
                .collect(Collectors.toList());
    }
}
