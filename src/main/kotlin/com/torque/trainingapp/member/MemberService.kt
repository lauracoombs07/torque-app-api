package com.torque.trainingapp.member

import com.torque.trainingapp.team.TeamCondensedDTO
import com.torque.trainingapp.team.TeamService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MemberService(
    var memberRepository: MemberRepository,
    var teamService: TeamService
) {
    fun getAllMembers(): List<MemberReturnDTO> {
        return memberRepository.findAll().map {
            MemberReturnDTO(
                it.id!!,
                it.firstName,
                it.lastName,
                it.email,
                it.torqueStartDate,
                it.roleId,
                TeamCondensedDTO(it.teamId, teamService.getTeamByIdCondensed(it.teamId).teamName)
            )
        }
    }

    fun getAllMembersByTeamId(teamId: UUID): List<MemberReturnDTO> {
        return memberRepository.findMembersByTeamId(teamId).map {
            MemberReturnDTO(
                it.id!!,
                it.firstName,
                it.lastName,
                it.email,
                it.torqueStartDate,
                it.roleId,
                TeamCondensedDTO(teamId, teamService.getTeamByIdCondensed(teamId).teamName)
            )
        }
    }

    fun getAllMembersCondensed(): List<MemberCondensedDTO> {
        return memberRepository.findAll().map {
            val name = it.firstName + " " + it.lastName
            MemberCondensedDTO(
                it.id!!,
                name,
                it.email,
            )
        }
    }
    fun getAllMembersByTeamIdCondensed(teamId: UUID): List<MemberCondensedDTO> {
        return memberRepository.findMembersByTeamId(teamId).map {
            val name = it.firstName + " " + it.lastName
            MemberCondensedDTO(
                it.id!!,
                name,
                it.email,
            )
        }
    }
    fun createMember(memberDTO: MemberDTO): Member {
        // member first name, last name, team and email are required
        val member = Member(
            null,
            memberDTO.firstName,
            memberDTO.lastName,
            memberDTO.email,
            memberDTO.torqueStartDate,
            memberDTO.roleId ?: UUID.randomUUID(),
            memberDTO.teamId
        )
        return memberRepository.save(member)
    }

    fun updateMemberById(id: UUID, memberDTO: MemberDTO): Member {
        val member = Member(
            id,
            memberDTO.firstName,
            memberDTO.lastName,
            memberDTO.email,
            memberDTO.torqueStartDate,
            memberDTO.roleId,
            memberDTO.teamId
        )
        return memberRepository.save(member)
    }

    fun deleteMemberById(id: UUID) {
        memberRepository.deleteById(id)
    }
}
