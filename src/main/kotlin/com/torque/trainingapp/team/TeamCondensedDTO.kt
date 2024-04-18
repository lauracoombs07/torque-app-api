package com.torque.trainingapp.team

import java.util.UUID

data class TeamCondensedDTO(
    var teamId: UUID = UUID.randomUUID(),
    var teamName: String = ""
) {
    constructor(team: Team) : this(team.pkId!!, team.teamName)
}
