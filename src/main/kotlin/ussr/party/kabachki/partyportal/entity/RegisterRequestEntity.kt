package ussr.party.kabachki.partyportal.entity

import ussr.party.kabachki.partyportal.dto.User
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "registration_request")
data class RegisterRequestEntity(
    @Embedded
    var user: User
) : BasedEntity()