package org.adaschool.TaskPlanner.controller.dto

data class TaskDto(
    val id: String,
    val description: String,
    //TODO changed to assignedTo
    val personResponsible:String,
    val dueDate: String,
    val status: String

)