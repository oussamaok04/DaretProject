package org.example.groupservice.repositories;

import org.example.groupservice.entities.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findByGroupGroupId(Long groupId);
    GroupMember findByMemberEmail(String memberEmail);
    GroupMember findByMemberPhone(String memberPhone);
}
