package org.example.contributionservice.services;

import org.example.contributionservice.entities.Contribution;

import java.util.List;

public interface ContributionService {
    public List<Contribution> getAllContributions();
    public Contribution getContributionById(Long id);
    public Contribution createContribution(Contribution contribution);
    public Contribution updateContribution(Contribution contribution);
    public void deleteContribution(Long id);
}
