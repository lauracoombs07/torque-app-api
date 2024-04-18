package com.torque.trainingapp.role

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "role")
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "pk_id")
    var pkId: UUID? = UUID.randomUUID(),

    @Column(name = "role_name")
    var roleName: String = "",

    @Column(name = "role_description")
    var roleDescription: String = ""
)
