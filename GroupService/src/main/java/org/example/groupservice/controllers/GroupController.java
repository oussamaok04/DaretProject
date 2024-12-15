package org.example.groupservice.controllers;

import org.example.groupservice.entities.Group;
import org.example.groupservice.entities.dto.GroupDTO;
import org.example.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/search/{id}")
    public ResponseEntity<Group> getGroupMemberById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(groupService.getGroup(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PostMapping("/save")
    public ResponseEntity<Group> createGroupMember(@RequestBody GroupDTO group) {
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @PutMapping("/update/{id}")
    public Group updateGroupMember(@PathVariable("id") Long id, @RequestBody GroupDTO group) {
        return groupService.updateGroup(group, id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteGroupMember(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok("Group removed");
    }



}
