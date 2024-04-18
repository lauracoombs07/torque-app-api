package com.torque.trainingapp.member

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/members")
class MemberController(
    var memberService: MemberService
) {

    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllMembers(): ResponseEntity<List<MemberReturnDTO>> {
        return ResponseEntity.ok(memberService.getAllMembers())
    }

    @GetMapping(produces = ["application/json;charset=UTF-8"], value = ["/team/{teamId}"])
    fun getAllMembersByTeamId(
        @PathVariable("teamId") teamId: UUID
    ): ResponseEntity<List<MemberReturnDTO>> {
        return ResponseEntity.ok(memberService.getAllMembersByTeamId(teamId))
    }

    @PostMapping(consumes = ["application/json"])
    fun createMember(
        @RequestBody memberDTO: MemberDTO
    ): ResponseEntity<Member> {
        return ResponseEntity.ok(memberService.createMember(memberDTO))
    }

    @PutMapping(consumes = ["application/json"], value = ["/{id}"])
    fun updateMember(
        @PathVariable("id") id: String,
        @RequestBody memberDTO: MemberDTO
    ): ResponseEntity<Member> {
        return ResponseEntity.ok(memberService.updateMemberById(UUID.fromString(id), memberDTO))
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteMember(
        @PathVariable("id") id: UUID
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(memberService.deleteMemberById(id))
    }
}


