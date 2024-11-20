package org.example.contributionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Contribution {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contributionId;
    private Double amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contributionDate;
}
