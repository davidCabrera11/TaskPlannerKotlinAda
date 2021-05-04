package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.controller.dto.TaskDto
import org.adaschool.TaskPlanner.data.document.Task

interface TaskService {

    //CRUD Operations

    //Create
    fun save(taskDto: TaskDto):Task

    //Update
    fun update(taskId: String,taskDto: TaskDto):Task

    //Read specific reserve
    fun findTaskById(taskId: String):Task?

    //Read all reserves
    fun all():List<Task>

    //Delete
    fun delete(taskId: String)

}