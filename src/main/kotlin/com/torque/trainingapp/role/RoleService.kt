package com.torque.trainingapp.role

import org.springframework.stereotype.Service

@Service
class RoleService(
    var roleRepository: RoleRepository
) {
    fun getAllRoles(): List<Role> {
        return roleRepository.findAll()
    }
}
