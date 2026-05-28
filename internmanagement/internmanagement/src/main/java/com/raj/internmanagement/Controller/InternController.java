package com.raj.internmanagement.Controller;

import com.raj.internmanagement.Model.Intern;
import com.raj.internmanagement.Service.InternService;
import com.raj.internmanagement.dto.InternDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private InternService internService;

    // GET all interns (with manager)
    @GetMapping
    public List<Intern> getAll() {
        return internService.getAllInterns();
    }

    // GET all interns basic info (without manager)
    @GetMapping("/basic")
    public List<InternDTO> getInternBasicDetails() {
        return internService.getInternDTOList();
    }

    @GetMapping("/{id}")
    public Intern getById(@PathVariable Long id) {
        return internService.getInternById(id);
    }

    // Add consumes attribute here:
//    @PostMapping(consumes = "application/json", produces = "application/json")
//    public Intern create(@RequestBody Intern intern) {
//        return internService.createIntern(intern);
//    }


    @PutMapping("/{id}")
    public Intern update(@PathVariable Long id, @RequestBody Intern intern) {
        return internService.updateIntern(id, intern);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        internService.deleteIntern(id);
    }

    @PutMapping("/{internId}/assign-manager/{managerId}")
    public Intern assignManager(@PathVariable Long internId, @PathVariable Long managerId) {
        return internService.assignManager(internId, managerId);
    }
}
