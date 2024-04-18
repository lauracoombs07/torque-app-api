package com.torque.trainingapp.team
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "team")
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "pk_id")
    var pkId: UUID? = UUID.randomUUID(),

    @Column(name = "team_name")
    var teamName: String = "",

    @Column(name = "team_nickname")
    var teamNickname: String? = null,

    @Column(name = "team_description")
    var description: String? = null,

    @Column(name = "ui_release_date")
    var uiReleaseDate: Date? = null,

    @Column(name = "api_release_date")
    var apiReleaseDate: Date? = null,

    @Column(name = "ui_app_version")
    var uiAppVersion: String? = null,

    @Column(name = "api_app_version")
    var apiAppVersion: String? = null
)
