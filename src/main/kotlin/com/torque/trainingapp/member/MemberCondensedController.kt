package com.torque.trainingapp.member

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/condensed-member")
class MemberCondensedController(
    var memberService: MemberService
) {
    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllMembersCondensed(): ResponseEntity<List<MemberCondensedDTO>> {
        return ResponseEntity.ok(memberService.getAllMembersCondensed())
    }

    @GetMapping(produces = ["application/json;charset=UTF-8"], value = ["/team/{teamId}"])
    fun getAllMembersByTeamIdCondensed(
        @PathVariable("teamId") teamId: UUID
    ): ResponseEntity<List<MemberCondensedDTO>> {
        return ResponseEntity.ok(memberService.getAllMembersByTeamIdCondensed(teamId))
    }
}
