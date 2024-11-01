package org.example.groupservice.services;

import org.example.groupservice.entities.GroupMember;

import java.util.List;

public interface GroupMemberService {
    GroupMember createGroupMember(GroupMember groupMember);
    GroupMember updateGroupMember(GroupMember groupMember);
    GroupMember getGroupMember(Long id);
    List<GroupMember> getAllGroupMembers();
    void deleteGroupMember(Long id);
}
