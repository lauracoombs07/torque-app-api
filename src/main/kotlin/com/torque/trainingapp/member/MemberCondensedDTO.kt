package com.torque.trainingapp.member

import java.util.UUID

data class MemberCondensedDTO(
    var memberId: UUID = UUID.randomUUID(),
    var name: String = "",
    var email: String = "",
)
