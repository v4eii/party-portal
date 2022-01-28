package ussr.party.kabachki.partyportal.entity

import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "initial_request")
data class InitialRequestEntity(
    @NotBlank
    var initiator: String,
    @NotBlank
    var requestTitle: String? = null,
    @Lob
    @NotBlank
    var description: String? = null
) : BasedEntity()