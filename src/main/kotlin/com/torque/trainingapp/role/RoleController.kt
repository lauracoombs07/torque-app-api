package com.torque.trainingapp.role

import com.torque.trainingapp.member.MemberReturnDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/roles")
class RoleController(
    var roleService: RoleService
) {
    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllRoles(): ResponseEntity<List<Role>> {
        return ResponseEntity.ok(roleService.getAllRoles())
    }
}
