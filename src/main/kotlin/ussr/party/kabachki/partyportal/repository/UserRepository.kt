package ussr.party.kabachki.partyportal.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ussr.party.kabachki.partyportal.entity.UserEntity

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByName(name: String): UserEntity
}