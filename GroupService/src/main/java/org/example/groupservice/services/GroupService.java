package org.example.groupservice.services;

import org.example.groupservice.entities.Group;
import org.example.groupservice.entities.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    Group createGroup(GroupDTO dto);
    Group updateGroup(GroupDTO dto, Long groupId);
    Group getGroup(Long id);
    List<Group> getAllGroups();
    void deleteGroup(Long id);
}
