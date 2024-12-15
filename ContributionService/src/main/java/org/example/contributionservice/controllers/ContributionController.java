package org.example.contributionservice.controllers;

import org.example.contributionservice.entities.Contribution;
import org.example.contributionservice.entities.dto.ContributionDTO;
import org.example.contributionservice.services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributions")
public class ContributionController {
    @Autowired
    private ContributionService contributionService;

    @GetMapping("/all")
    public ResponseEntity<List<Contribution>> getAllContributions() {
        return ResponseEntity.ok(contributionService.getAllContributions());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Contribution> getContributionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(contributionService.getContributionById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Contribution> saveContribution(@RequestBody ContributionDTO contribution) {
        return ResponseEntity.ok(contributionService.createContribution(contribution));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contribution> updateContribution(@PathVariable("id") Long id, @RequestBody ContributionDTO contribution) {
        return ResponseEntity.ok(contributionService.updateContribution(contribution, id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeContribution(@PathVariable("id") Long id) {
        contributionService.deleteContribution(id);
        return ResponseEntity.ok("Removed contribution with id " + id);
    }
}
