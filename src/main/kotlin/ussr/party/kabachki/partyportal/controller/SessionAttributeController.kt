package ussr.party.kabachki.partyportal.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.SessionAttributes

@SessionAttributes(names = ["user", "weather"])
interface SessionAttributeController {
    fun Model.moveNextOrGoHome(next: String): String {
        return if (getAttribute("user") != null) next else "redirect:/"
    }
}