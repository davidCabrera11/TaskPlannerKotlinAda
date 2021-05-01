package org.adaschool.TaskPlanner.controller.auth

import org.adaschool.TaskPlanner.controller.dto.LoginDto
import org.adaschool.TaskPlanner.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(
    @Value("\${SECRET}") val secret: String,
    @Autowired val userService: UserService
) {

    @PostMapping
    fun authenticate(@RequestBody loginDto: LoginDto){



    }





}