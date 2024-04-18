package com.torque.trainingapp.team

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TeamRepository: JpaRepository<Team, UUID> {
    fun findByTeamName(teamName: String): Team
    fun findTeamByPkId(id: UUID): Team
    fun deleteTeamByPkId(id: UUID)
}
