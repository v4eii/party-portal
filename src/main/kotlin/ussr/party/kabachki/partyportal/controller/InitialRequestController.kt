package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.entity.InitialRequestEntity
import ussr.party.kabachki.partyportal.repository.InitialRequestRepository

@Controller
@RequestMapping("/initial-request")
class InitialRequestController(
    private val initialRequestRepository: InitialRequestRepository
) : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(
        model: Model,
        @ModelAttribute("user")
        user: User
    ): String {
        model.addAttribute("initialRequest", InitialRequestDTO(initiator = user.name))

        return model.moveNextOrGoHome("initial-request/index.html")
    }

    @PostMapping("/new")
    fun createRequest(
        @ModelAttribute
        initialRequestDTO: InitialRequestDTO
    ): String {
        with(initialRequestDTO) {
            initialRequestRepository.save(
                InitialRequestEntity(
                    initiator = initiator,
                    requestTitle = requestTitle,
                    description = description
                )
            )
        }

        return "index"
    }
}