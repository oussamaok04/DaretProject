package org.example.groupservice.entities.dto;

import org.example.groupservice.entities.Group;

public record GroupDTO(
        String groupName,
        String description
) {
    public Group toGroup() {
        return Group.builder()
                .groupName(this.groupName())
                .description(this.description())
                .build();
    }
}
