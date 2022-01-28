package ussr.party.kabachki.partyportal.dto

import javax.validation.constraints.NotBlank

data class InitialRequestDTO(
    @NotBlank
    val initiator: String = "",
    @NotBlank
    val requestTitle: String = "",
    @NotBlank
    val description: String = ""
)
