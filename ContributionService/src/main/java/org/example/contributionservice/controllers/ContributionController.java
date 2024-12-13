package org.example.contributionservice.controllers;

import org.example.contributionservice.entities.Contribution;
import org.example.contributionservice.services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContributionController {
    @Autowired
    private ContributionService contributionService;

    @GetMapping("/")
    public String hello(){
        return "Hello to contribution service";
    }

    @GetMapping("/contributions/all")
    public List<Contribution> getAllContributions() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/contributions/{id}")
    public Contribution getContributionById(@PathVariable("id") Long id) {
        return contributionService.getContributionById(id);
    }

    @PostMapping("/contributions/save")
    public Contribution saveContribution(@RequestBody Contribution contribution) {
        return contributionService.createContribution(contribution);
    }
}
