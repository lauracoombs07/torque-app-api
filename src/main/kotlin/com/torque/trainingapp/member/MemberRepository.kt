package com.torque.trainingapp.member

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MemberRepository: JpaRepository<Member, UUID> {
    fun findByEmail(email: String): Member
    fun findMemberById(id: UUID): Member
    fun findMembersByTeamId(teamId: UUID): List<Member>
}
