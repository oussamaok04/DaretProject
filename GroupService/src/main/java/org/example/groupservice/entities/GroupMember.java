package org.example.groupservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.groupservice.entities.dto.MemberDTO;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class GroupMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupMemberId;
    private String memberName;
    private String memberPhone;
    private String memberEmail;

    @ManyToOne
    @JsonBackReference
    private Group group;
}
