package org.example.javatokoltintest250318.service

import org.example.javatokoltintest250318.entity.User
import org.example.javatokoltintest250318.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {
    // C
    fun createUser(username: String, email: String): User {
        val user = User()
        user.username = username
        user.email = email

        return userRepository.save(user)
    }

    // R
    fun getUser(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    // U
    fun updateUser(id: Long, updateUsername: String): User {
        val user = userRepository.findById(id)
            .orElseThrow { RuntimeException("User not found") }

        user.username = updateUsername

        return userRepository.save(user)
    }

    // D
    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
