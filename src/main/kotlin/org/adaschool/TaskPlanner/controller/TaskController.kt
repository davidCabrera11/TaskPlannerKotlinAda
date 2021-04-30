package org.adaschool.TaskPlanner.controller

import org.adaschool.TaskPlanner.controller.dto.TaskDto
import org.adaschool.TaskPlanner.controller.dto.UserDto
import org.adaschool.TaskPlanner.model.Task
import org.adaschool.TaskPlanner.model.User
import org.adaschool.TaskPlanner.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/v1/tasks")
class TaskController(@Autowired val taskService: TaskService){

    //CRUD Operations

    //Create
    @PostMapping
    fun create(@RequestBody taskDto: TaskDto): Task {
        return taskService.save(taskDto)

    }

    //Read
    @GetMapping
    fun getTasks():List<Task>?{
        return taskService.all()

    }

    //Read for specific user
    @GetMapping("/{id}")
    fun findTaskById(@PathVariable id:String): Task?{
        return taskService.findTaskById(id) ?:throw Exception()

    }

    //Update
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody taskDto: TaskDto): Task?{
        return taskService.update(id,taskDto)

    }
    //Delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:String):Boolean{
        return taskService.delete(id)


    }



}