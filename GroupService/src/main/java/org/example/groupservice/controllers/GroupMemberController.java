package org.example.groupservice.controllers;

import org.example.groupservice.entities.GroupMember;
import org.example.groupservice.services.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class GroupMemberController {

    GroupMemberService groupMemberService;

    @Autowired
    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @GetMapping("/search/{id}")
    public GroupMember getGroupMemberById(@PathVariable("id") Long id) {
        return groupMemberService.getGroupMember(id);
    }

    @PostMapping("/save")
    public GroupMember createGroupMember(@RequestBody GroupMember groupMember) {
        return groupMemberService.createGroupMember(groupMember);
    }
}
