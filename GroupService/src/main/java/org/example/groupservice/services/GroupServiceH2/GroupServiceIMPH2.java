package org.example.groupservice.services.GroupServiceH2;

import jakarta.transaction.Transactional;
import org.example.groupservice.entities.Group;
import org.example.groupservice.repositories.GroupRepository;
import org.example.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GroupServiceIMPH2 implements GroupService {

    GroupRepository groupRepository;

    @Autowired
    public GroupServiceIMPH2(GroupRepository groupRepository) {}

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        return null;
    }

    @Override
    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
