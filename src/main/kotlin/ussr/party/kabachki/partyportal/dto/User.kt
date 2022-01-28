package ussr.party.kabachki.partyportal.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

data class User(
    @NotBlank
    val name: String,
    @Email(message = "email should be valid")
    val email: String?,
    @PositiveOrZero
    val rice: Long,
    val role: String,
    @Min(12)
    val age: Int,
    val weight: Int?,
    val height: Int?,
    val about: String?
)
