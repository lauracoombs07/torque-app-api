package com.torque.trainingapp.team

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/condensed-teams")
class TeamCondensedController(
    var teamService: TeamService
) {
    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllTeamsCondensed(): ResponseEntity<List<TeamCondensedDTO>> {
        return ResponseEntity.ok(teamService.getAllTeamsCondensed())
    }

    @GetMapping(produces = ["application/json;charset=UTF-8"], value = ["/{id}"])
    fun getTeamsCondensedById(
        @PathVariable("id") id: UUID
    ): ResponseEntity<TeamCondensedDTO> {
        return ResponseEntity.ok(teamService.getTeamByIdCondensed(id))
    }
}
