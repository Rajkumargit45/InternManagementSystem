package com.raj.internmanagement.Controller;

import com.raj.internmanagement.Model.Manager;
import com.raj.internmanagement.Service.ManagerService;
import com.raj.internmanagement.dto.ManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    // GET /api/managers — List all managers with full intern details
    @GetMapping
    public List<Manager> getAll() {
        return managerService.getAllManagers();
    }

    // GET /api/managers/basic — List all managers basic info only (no interns)

    @GetMapping("/basic")
    public List<ManagerDTO> getAllManagersBasic() {
        return managerService.getAllManagerDTOs();
    }

    @PostMapping
    public Manager create(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @GetMapping("/{id}")
    public Manager getById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @PutMapping("/{id}")
    public Manager update(@PathVariable Long id, @RequestBody Manager manager) {
        return managerService.updateManager(id, manager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}
