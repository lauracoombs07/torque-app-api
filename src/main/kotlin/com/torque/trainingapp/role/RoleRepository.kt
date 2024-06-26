package com.torque.trainingapp.role

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RoleRepository: JpaRepository<Role, UUID> {
}
