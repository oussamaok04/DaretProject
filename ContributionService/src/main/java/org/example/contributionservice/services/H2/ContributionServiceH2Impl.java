package org.example.contributionservice.services.H2;

import jakarta.transaction.Transactional;
import org.example.contributionservice.entities.Contribution;
import org.example.contributionservice.entities.dto.ContributionDTO;
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
        return contributionRepository.findById(id).orElseThrow(() -> new RuntimeException("Contribution not found"));
    }

    @Override
    public Contribution createContribution(ContributionDTO dto) {
        return contributionRepository.save(dto.toContribution());
    }

    @Override
    public Contribution updateContribution(ContributionDTO dto, Long contributionId) throws RuntimeException {
        Contribution contribution = this.getContributionById(contributionId);
        if (contribution == null) {
            throw new RuntimeException("Contribution not found");
        } else {
            contribution.setContributionDate(dto.contributionDate());
            contribution.setAmount(dto.amount());
            return contributionRepository.save(contribution);
        }
    }

    @Override
    public void deleteContribution(Long id) {
        contributionRepository.deleteById(id);
    }
}
