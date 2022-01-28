package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.ui.Model
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.service.InitialRequestService
import ussr.party.kabachki.partyportal.service.UserService

fun Model.updateUserAttribute(userService: UserService) =
    addAttribute("user", userService.getUser(SecurityContextHolder.getContext().authentication.name))

fun Model.initializeNewRequestAttribute() =
    (this.getAttribute("user") as User?)?.let {
        addAttribute("initialRequest", InitialRequestDTO(initiator = it.name))
    } ?: this

fun Model.addRequestsAttribute(initialRequestService: InitialRequestService) =
    addAttribute("requests", initialRequestService.findAll())