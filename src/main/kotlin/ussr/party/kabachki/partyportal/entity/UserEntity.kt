package ussr.party.kabachki.partyportal.entity

import ussr.party.kabachki.partyportal.enums.PartyRole
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "users")
data class UserEntity(
    @NotBlank
    var name: String,
    @Email
    var email: String?,
    @PositiveOrZero
    var rice: Long,
    @Enumerated(value = EnumType.STRING)
    var role: PartyRole,
    @Min(12)
    var age: Int,
    var weight: Int?,
    var height: Int?,
    var about: String?,
    @NotBlank
    var password: String,
    var authority: String,
    var enabled: Boolean
) : BasedEntity()