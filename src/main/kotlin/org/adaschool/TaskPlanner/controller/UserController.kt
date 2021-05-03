package org.adaschool.TaskPlanner.controller

import org.adaschool.TaskPlanner.controller.dto.UserDto
import org.adaschool.TaskPlanner.model.User
import org.adaschool.TaskPlanner.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/v1/users")
class UserController(@Autowired val userService: UserService) {

    //CRUD Operations

    //Create
    @PostMapping
    fun create(@RequestBody userDto: UserDto): User {
        return userService.save(userDto)

    }

    //Read
    @GetMapping
    fun getUsers():List<User>?{
        return userService.all()

    }

    //Read for specific user
    @GetMapping("/{id}")
    fun findUserById(@PathVariable id:String): User?{
        return userService.findUserById(id) ?:throw Exception()

    }

    //Update
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody userDto: UserDto): User?{
        return userService.update(id,userDto)

    }
    //Delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:String):Boolean{
        return userService.delete(id)


    }


}