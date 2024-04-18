package com.torque.trainingapp.member

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
@Table(name = "member")
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "pk_id")
    var id: UUID? = UUID.randomUUID(),

    @Column(name = "first_name")
    var firstName: String = "",

    @Column(name = "last_name")
    var lastName: String = "",

    var email: String = "",

    @Column(name = "torque_start_date")
    var torqueStartDate: Date? = null,

    @Column(name = "fk_role_id")
    var roleId: UUID = UUID.randomUUID(),

    @Column(name = "fk_team_id")
    var teamId: UUID = UUID.randomUUID()
)
