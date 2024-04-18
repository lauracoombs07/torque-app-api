package com.torque.trainingapp.team

import java.util.Date
import java.util.UUID

data class TeamDTO(
    var pkId: UUID? = UUID.randomUUID(),
    var teamName: String = "",
    var teamNickname: String = "",
    var description: String = "",
    var uiReleaseDate: Date = Date(),
    var apiReleaseDate: Date = Date(),
    var uiAppVersion: String = "",
    var apiAppVersion: String = ""
)
