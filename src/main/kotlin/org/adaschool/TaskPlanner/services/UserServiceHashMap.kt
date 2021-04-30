package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.controller.dto.UserDto
import org.adaschool.TaskPlanner.model.User
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class UserServiceHashMap:UserService {

    private val users = HashMap<String,User>()

    private val nextOid = AtomicLong()

    init {


    }

    private fun createSampleUser(){
        val id: String = "1234"
        val user = User(

            nextOid.incrementAndGet(),
            id,
            "David",
            BCrypt.hashpw("password1",BCrypt.gensalt()),
            "davidcab11@gmail.com",
            "https://www.imgur.com/kotlin-image"
        )

        users[id] = user

    }



    override fun save(userDto: UserDto): User {
        val user = User(nextOid.incrementAndGet(),userDto)
        users[userDto.id] = user
        return user

    }

    override fun update(userId: String, userDto: UserDto): User {
        if (users.containsKey(userId)){
            val user = users[userId]
            users[userId] = User(user!!.oid,userDto)
        }
        return users[userId]!!

    }

    override fun findUserById(userId: String): User? {
        return if (users.containsKey(userId))
            users[userId]
        else
            null

    }

    override fun findByEmail(email: String): User? {
        return if (users.containsKey(email))
            users[email]
        else
            null
    }

    override fun all(): List<User> {
        return users.values.toList()

    }

    override fun delete(userId: String): Boolean {
        return users.remove(userId) != null
    }

}