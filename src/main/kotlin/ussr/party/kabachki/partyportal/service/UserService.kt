package ussr.party.kabachki.partyportal.service

import org.springframework.stereotype.Service
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.entity.UserEntity
import ussr.party.kabachki.partyportal.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUser(name: String): User = userRepository.findByName(name).toDto()

    fun User.minusSocialCredit() {
        userRepository.findByName(name).decrementRice()
    }

    fun UserEntity.toDto() = User(
        name = name,
        email = email,
        rice = rice,
        role = role.toString(),
        age = age,
        weight = weight,
        height = height,
        about = about
    )

    fun UserEntity.decrementRice() {
        this.rice--
        userRepository.save(this)
    }
}