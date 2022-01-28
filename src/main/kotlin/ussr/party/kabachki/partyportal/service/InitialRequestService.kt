package ussr.party.kabachki.partyportal.service

import org.springframework.stereotype.Service
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.entity.InitialRequestEntity
import ussr.party.kabachki.partyportal.repository.InitialRequestRepository

@Service
class InitialRequestService(
    private val initialRequestRepository: InitialRequestRepository,
    private val userService: UserService
) {

    fun saveRequest(initialRequestDTO: InitialRequestDTO, user: User) {
        val isLiar = user.name != initialRequestDTO.initiator

        with(userService) {
            if (isLiar) {
                user.minusSocialCredit()
            }
            initialRequestRepository.save(
                initialRequestDTO.toEntity(
                    if (isLiar) user.name else initialRequestDTO.initiator
                )
            )
        }
    }

    fun findAll() = initialRequestRepository.findAll().toList()


    fun InitialRequestDTO.toEntity(initiator: String) = InitialRequestEntity(
        initiator = initiator,
        requestTitle = requestTitle,
        description = description
    )
}