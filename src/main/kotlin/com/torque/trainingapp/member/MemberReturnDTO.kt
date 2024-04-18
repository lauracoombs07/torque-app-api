package com.torque.trainingapp.member

import com.torque.trainingapp.team.TeamCondensedDTO
import java.util.Date
import java.util.UUID

data class MemberReturnDTO(
    var id: UUID,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var torqueStartDate: Date? = Date(),
    var roleId: UUID = UUID.randomUUID(),
    var team: TeamCondensedDTO = TeamCondensedDTO()
)
