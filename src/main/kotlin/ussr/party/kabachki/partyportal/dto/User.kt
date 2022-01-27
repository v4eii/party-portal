package ussr.party.kabachki.partyportal.dto

data class User(
    val name: String,
    val email: String?,
    val rice: Long,
    val role: String,
    val age: Int,
    val weight: Int?,
    val height: Int?,
    val about: String?
)
