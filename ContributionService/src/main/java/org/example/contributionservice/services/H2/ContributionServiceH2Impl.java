package org.example.contributionservice.services.H2;

import jakarta.transaction.Transactional;
import org.example.contributionservice.entities.Contribution;
import org.example.contributionservice.repositories.ContributionRepository;
import org.example.contributionservice.services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContributionServiceH2Impl implements ContributionService {
    @Autowired
    private ContributionRepository contributionRepository;

    @Override
    public List<Contribution> getAllContributions() {
        return contributionRepository.findAll();
    }

    @Override
    public Contribution getContributionById(Long id) {
        return contributionRepository.getReferenceById(id);
    }

    @Override
    public Contribution createContribution(Contribution contribution) {
        return contributionRepository.save(contribution);
    }

    @Override
    public Contribution updateContribution(Contribution contribution) {
        return null;
    }

    @Override
    public void deleteContribution(Long id) {
        contributionRepository.deleteById(id);
    }
}
