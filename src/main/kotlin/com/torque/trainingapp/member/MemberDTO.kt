package com.torque.trainingapp.member

import java.util.Date
import java.util.UUID

data class MemberDTO(
    var id: UUID? = UUID.randomUUID(),
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var torqueStartDate: Date = Date(),
    var roleId: UUID,
    var teamId: UUID,
)
