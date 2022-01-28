package ussr.party.kabachki.partyportal.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

data class User(
    @NotBlank
    val name: String,
    @Email(message = "email should be valid")
    var email: String?,
    @PositiveOrZero
    var rice: Long,
    val role: String,
    @Min(12)
    var age: Int,
    var weight: Int?,
    var height: Int?,
    var about: String?,
    var password: String? = null
)
