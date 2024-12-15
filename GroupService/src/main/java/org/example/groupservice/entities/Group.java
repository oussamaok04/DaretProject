package org.example.groupservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor @Builder
@Table(name = "groupDaret")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private String description;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<GroupMember> members;
}
