package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.ui.Model
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.schedule.DataScheduler
import ussr.party.kabachki.partyportal.service.InitialRequestService
import ussr.party.kabachki.partyportal.service.UserService

fun Model.updateUserAttribute(userService: UserService) =
    addAttribute("user", userService.getUser(SecurityContextHolder.getContext().authentication.name))

fun Model.initializeNewRequestAttribute() =
    getCastedAttributeOrNull<User>("user")?.let {
        addAttribute("initialRequest", InitialRequestDTO(initiator = it.name))
    } ?: this

fun Model.addRequestsAttribute(initialRequestService: InitialRequestService) =
    addAttribute("requests", initialRequestService.findAll())

fun Model.updateTemperatureAttribute(dataScheduler: DataScheduler): Model {
    val temp = dataScheduler.weatherDTO.main.temp
    return getCastedAttributeOrNull<Double>("weather")?.let {
        if (it == temp) addAttribute("weather", temp) else this
    } ?: this
}

inline fun <reified T> Model.getCastedAttributeOrNull(attributeName: String): T? {
    val attribute = getAttribute(attributeName)
    return if (attribute is T) {
        attribute
    } else {
        null
    }
}
