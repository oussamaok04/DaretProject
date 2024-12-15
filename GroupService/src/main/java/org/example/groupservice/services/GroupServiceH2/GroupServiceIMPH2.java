package org.example.groupservice.services.GroupServiceH2;

import jakarta.transaction.Transactional;
import org.example.groupservice.entities.Group;
import org.example.groupservice.entities.dto.GroupDTO;
import org.example.groupservice.repositories.GroupRepository;
import org.example.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GroupServiceIMPH2 implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group createGroup(GroupDTO dto) {
        return groupRepository.save(dto.toGroup());
    }

    @Override
    public Group updateGroup(GroupDTO dto, Long groupId) throws RuntimeException{
        Group group = this.getGroup(groupId);
        if (group == null) {
            throw new RuntimeException("Group not found");
        } else {
            group.setGroupName(dto.groupName());
            group.setDescription(dto.description());
            return groupRepository.save(group);
        }
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
