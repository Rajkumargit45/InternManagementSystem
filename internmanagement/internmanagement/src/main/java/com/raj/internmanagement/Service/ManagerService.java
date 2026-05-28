package com.raj.internmanagement.Service;

import com.raj.internmanagement.Model.Manager;
import com.raj.internmanagement.dto.ManagerDTO;
import com.raj.internmanagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + id));
    }

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager updateManager(Long id, Manager updated) {
        Manager existing = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + id));
        existing.setName(updated.getName());
        existing.setDepartment(updated.getDepartment());
        return managerRepository.save(existing);
    }

    public void deleteManager(Long id) {
        if (!managerRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Manager not found with ID: " + id);
        }
        managerRepository.deleteById(id);
    }

    // Return ManagerDTO list (without intern details)

    public List<ManagerDTO> getAllManagerDTOs() {
        return managerRepository.findAll()
                .stream()
                .map(manager -> new ManagerDTO(
                        manager.getManagerId(),
                        manager.getName(),
                        manager.getDepartment()
                ))
                .collect(Collectors.toList());
    }
}
