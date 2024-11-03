package org.example.groupservice.controllers;

import org.example.groupservice.entities.Group;
import org.example.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/search/{id}")
    public Group getGroupMemberById(@PathVariable("id") Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping("/save")
    public Group createGroupMember(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

}
