package org.example.groupservice.entities.dto;

import org.example.groupservice.entities.GroupMember;

public record MemberDTO (
        String memberName,
        String memberPhone,
        String memberEmail,
        long groupId
){
    public GroupMember toGroupMember(){
        return GroupMember.builder()
                .memberEmail(this.memberEmail())
                .memberName(this.memberName())
                .memberPhone(this.memberPhone())
                .build();
    }
}
