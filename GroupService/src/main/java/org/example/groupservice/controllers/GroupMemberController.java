package org.example.groupservice.controllers;

import org.example.groupservice.entities.GroupMember;
import org.example.groupservice.entities.dto.MemberDTO;
import org.example.groupservice.services.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class GroupMemberController {

    @Autowired
    GroupMemberService groupMemberService;

    @GetMapping("/search/{id}")
    public GroupMember getGroupMemberById(@PathVariable("id") Long id) {
        return groupMemberService.getGroupMember(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupMember>> getAllGroupMembers() {
        return ResponseEntity.ok(groupMemberService.getAllGroupMembers());
    }

    @PostMapping("/save")
    public GroupMember createGroupMember(@RequestBody MemberDTO groupMember) {
        return groupMemberService.createGroupMember(groupMember);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GroupMember> updateGroupMember(@PathVariable("id") Long id, @RequestBody MemberDTO groupMember) {
        return ResponseEntity.ok(groupMemberService.updateGroupMember(groupMember, id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeGroupMember(@PathVariable("id") Long id) {
        groupMemberService.deleteGroupMember(id);
        return ResponseEntity.ok("Member removed successfully");
    }


}
