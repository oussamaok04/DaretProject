package org.example.groupservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor
@Table(name = "groupDaret")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private String description;

    @OneToMany(mappedBy = "group")
    List<GroupMember> members;
}
