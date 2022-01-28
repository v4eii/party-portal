package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.service.UserService

@Controller
class HomeController(
    private val userService: UserService
) : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model): String = model.moveNextOrGoHome("index")

    @ModelAttribute("user")
    fun initializeUser(model: Model) {
        model.addAttribute(
            "user",
            userService.getUser(SecurityContextHolder.getContext().authentication.name)
        )
    }
}