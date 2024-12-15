package org.example.contributionservice.entities.dto;

import org.example.contributionservice.entities.Contribution;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ContributionDTO(
        Double amount,
        LocalDate contributionDate
) {
    public Contribution toContribution() {
        return Contribution.builder()
                .contributionDate(this.contributionDate())
                .amount(this.amount())
                .build();
    }
}
