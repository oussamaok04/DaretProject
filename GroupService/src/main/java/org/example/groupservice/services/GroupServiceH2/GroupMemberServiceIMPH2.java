package org.example.groupservice.services.GroupServiceH2;

import jakarta.transaction.Transactional;
import org.example.groupservice.entities.GroupMember;
import org.example.groupservice.repositories.GroupMemberRepository;
import org.example.groupservice.repositories.GroupRepository;
import org.example.groupservice.services.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GroupMemberServiceIMPH2 implements GroupMemberService {

    GroupMemberRepository groupMemberRepository;

    @Autowired
    public GroupMemberServiceIMPH2(GroupMemberRepository groupMemberRepository) {
        this.groupMemberRepository = groupMemberRepository;
    }

    @Override
    public GroupMember createGroupMember(GroupMember groupMember) {
        return groupMemberRepository.save(groupMember);
    }

    @Override
    public GroupMember updateGroupMember(GroupMember groupMember) {
        return null;
    }

    @Override
    public GroupMember getGroupMember(Long id) {
        return groupMemberRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupMember> getAllGroupMembers() {
        return groupMemberRepository.findAll();
    }

    @Override
    public void deleteGroupMember(Long id) {
        groupMemberRepository.deleteById(id);
    }
}
