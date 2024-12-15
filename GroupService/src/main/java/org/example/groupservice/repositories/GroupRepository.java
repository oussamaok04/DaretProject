package org.example.groupservice.repositories;

import org.example.groupservice.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByGroupName(String name);
    List<Group> findByGroupNameContaining(String name);
}
