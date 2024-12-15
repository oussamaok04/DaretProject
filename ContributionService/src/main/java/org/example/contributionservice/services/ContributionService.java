package org.example.contributionservice.services;

import org.example.contributionservice.entities.Contribution;
import org.example.contributionservice.entities.dto.ContributionDTO;

import java.util.List;

public interface ContributionService {
    public List<Contribution> getAllContributions();
    public Contribution getContributionById(Long id);
    public Contribution createContribution(ContributionDTO dto);
    public Contribution updateContribution(ContributionDTO dto, Long contribuionId);
    public void deleteContribution(Long id);
}
