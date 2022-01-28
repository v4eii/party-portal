package ussr.party.kabachki.partyportal.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import ussr.party.kabachki.partyportal.entity.UserEntity
import ussr.party.kabachki.partyportal.enums.PartyRole
import ussr.party.kabachki.partyportal.repository.UserRepository

@Configuration
@Profile("h2")
class BootstrapData(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val userEntity = UserEntity(
            name = "v4eii",
            email = "xxx@gmail.com",
            rice = 15L,
            role = PartyRole.CUMRADE,
            age = 21,
            weight = 80,
            height = 190,
            about = "yes",
            password = passwordEncoder.encode("123456"),
            authority = "ROLE_USER",
            enabled = true
        )
        userRepository.save(userEntity)
        println("Load data...")
    }
}