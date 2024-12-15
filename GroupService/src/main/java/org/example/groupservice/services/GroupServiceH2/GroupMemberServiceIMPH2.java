package org.example.groupservice.services.GroupServiceH2;

import jakarta.transaction.Transactional;
import org.example.groupservice.entities.Group;
import org.example.groupservice.entities.GroupMember;
import org.example.groupservice.entities.dto.MemberDTO;
import org.example.groupservice.repositories.GroupMemberRepository;
import org.example.groupservice.repositories.GroupRepository;
import org.example.groupservice.services.GroupMemberService;
import org.example.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GroupMemberServiceIMPH2 implements GroupMemberService {

    @Autowired
    GroupMemberRepository groupMemberRepository;
    @Autowired
    GroupService groupService;


    @Override
    public GroupMember createGroupMember(MemberDTO dto) {
        Group group = groupService.getGroup(dto.groupId());
        GroupMember groupMember = dto.toGroupMember();
        groupMember.setGroup(group);
        return groupMemberRepository.save(groupMember);
    }

    @Override
    public GroupMember updateGroupMember(MemberDTO dto, Long memberId) throws RuntimeException{
        GroupMember groupMember = this.getGroupMember(memberId);
        if (groupMember == null) {
            throw new RuntimeException("Group member not found");
        } else {
            groupMember.setMemberEmail(dto.memberEmail());
            groupMember.setMemberName(dto.memberName());
            groupMember.setMemberPhone(dto.memberPhone());
            return groupMemberRepository.save(groupMember);
        }
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

    @Override
    public List<GroupMember> getGroupMembersByGroup(Long groupId) {
        return groupMemberRepository.findByGroupGroupId(groupId);
    }

    @Override
    public GroupMember getGroupMemberByMemberEmail(String email) {
        return groupMemberRepository.findByMemberEmail(email);
    }

    @Override
    public GroupMember getGroupMemberByMemberPhone(String phone) {
        return groupMemberRepository.findByMemberPhone(phone);
    }
}
