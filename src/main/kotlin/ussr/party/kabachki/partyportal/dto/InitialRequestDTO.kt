package ussr.party.kabachki.partyportal.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class InitialRequestDTO(
    @NotBlank
    val initiator: String = "",
    @Size(min = 2)
    @NotBlank
    val requestTitle: String = "",
    @Size(min = 2)
    @NotBlank
    val description: String = ""
)
