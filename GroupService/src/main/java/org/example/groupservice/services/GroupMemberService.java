package org.example.groupservice.services;

import org.example.groupservice.entities.Group;
import org.example.groupservice.entities.GroupMember;
import org.example.groupservice.entities.dto.MemberDTO;

import java.util.List;

public interface GroupMemberService {
    GroupMember createGroupMember(MemberDTO dto);
    GroupMember updateGroupMember(MemberDTO dto, Long memberId);
    GroupMember getGroupMember(Long id);
    List<GroupMember> getAllGroupMembers();
    void deleteGroupMember(Long id);
    List<GroupMember> getGroupMembersByGroup(Long groupId);
    GroupMember getGroupMemberByMemberEmail(String email);
    GroupMember getGroupMemberByMemberPhone(String phone);
}
