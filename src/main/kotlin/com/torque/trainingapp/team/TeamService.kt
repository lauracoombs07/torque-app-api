package com.torque.trainingapp.team

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TeamService(
    var teamRepository: TeamRepository
) {
    fun getAllTeams(): List<Team> {
        return teamRepository.findAll()
    }

    // should condensed have it's own service?
    fun getAllTeamsCondensed(): List<TeamCondensedDTO> {
        return teamRepository.findAll().map {
            TeamCondensedDTO(it.pkId!!, it.teamName)
        }
    }

    fun getTeamByIdCondensed(id: UUID): TeamCondensedDTO {
        val team = teamRepository.findTeamByPkId(id)
        return TeamCondensedDTO(team.pkId!!, team.teamName)
    }

    fun getTeamByName(teamName: String): Team {
        return teamRepository.findByTeamName(teamName)
    }

    fun getTeamById(id: UUID): Team {
        return teamRepository.findTeamByPkId(id)
    }

    fun createTeam(teamDTO: TeamDTO): Team {
        // team name must be unique
        // team name cannot be null

        val team = Team(
            null,
            teamDTO.teamName,
            teamDTO.teamNickname,
            teamDTO.description,
            teamDTO.uiReleaseDate,
            teamDTO.apiReleaseDate,
            teamDTO.uiAppVersion,
            teamDTO.apiAppVersion
        )
        return teamRepository.save(team)
    }

    fun updateTeam(teamDTO: TeamDTO): Team {
        val team = Team(
            teamDTO.pkId,
            teamDTO.teamName,
            teamDTO.teamNickname,
            teamDTO.description,
            teamDTO.uiReleaseDate,
            teamDTO.apiReleaseDate,
            teamDTO.uiAppVersion,
            teamDTO.apiAppVersion
        )
        return teamRepository.save(team)
    }

    fun deleteTeam(id: UUID) {
        // if team has members, delete will cascade -> members
        teamRepository.deleteTeamByPkId(id)
    }
}
