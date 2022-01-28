package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.service.InitialRequestService
import ussr.party.kabachki.partyportal.service.UserService

@Validated
@Controller
@RequestMapping("/initial-request")
class InitialRequestController(
    private val initialRequestService: InitialRequestService,
    private val userService: UserService
) : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun requestHandler(
        model: Model
    ): String = model.initializeNewRequestAttribute()
        .addRequestsAttribute(initialRequestService)
        .moveNextOrGoHome("initial-request/index.html")


    @PostMapping("/new")
    fun createRequest(
        @ModelAttribute("initialRequest")
        initialRequestDTO: InitialRequestDTO,
        @ModelAttribute("user")
        user: User,
        model: Model
    ): String {
        initialRequestService.saveRequest(initialRequestDTO, user)

        return model.updateUserAttribute(userService).moveNextOrGoHome("index")
    }
}