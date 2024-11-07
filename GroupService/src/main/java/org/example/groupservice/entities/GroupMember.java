package org.example.groupservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroupMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupMemberId;
    @ManyToOne
    private Group group;
}
