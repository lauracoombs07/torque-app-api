package com.torque.trainingapp.team

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
@RequestMapping("api/teams")
class TeamController(
    var teamService: TeamService
) {

    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllTeams(): ResponseEntity<List<Team>> {
        return ResponseEntity.ok(teamService.getAllTeams())
    }

    @GetMapping(produces = ["application/json;charset=UTF-8"], value = ["/{teamName}"])
    fun getTeamByName(
        @PathVariable("teamName") teamName: String
    ): ResponseEntity<Team> {
        return ResponseEntity.ok(teamService.getTeamByName(teamName))
    }

    @GetMapping(produces = ["application/json;charset=UTF-8"], value = ["/{id}"])
    fun getTeamById(
        @PathVariable("id") id: UUID
    ): ResponseEntity<Team> {
        return ResponseEntity.ok(teamService.getTeamById(id))
    }

    @PostMapping(consumes = ["application/json"])
    fun createTeam(
        @RequestBody teamDTO: TeamDTO
    ): ResponseEntity<Team> {
       return ResponseEntity.ok(teamService.createTeam(teamDTO))
    }

    @PutMapping(consumes = ["application/json"], value = ["/{teamName}"])
    fun updateTeam(
        @PathVariable("teamName") teamName: String,
        @RequestBody teamDTO: TeamDTO
    ): ResponseEntity<Team> {
       return ResponseEntity.ok(teamService.updateTeam(teamDTO))
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteTeam(
        @PathVariable("id") id: UUID
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(teamService.deleteTeam(id))
    }
}
