package org.example.groupservice.services;

import org.example.groupservice.entities.Group;

import java.util.List;

public interface GroupService {
    Group createGroup(Group group);
    Group updateGroup(Group group);
    Group getGroup(Long id);
    List<Group> getAllGroups();
    void deleteGroup(Long id);
}
