package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.dto.User

@Controller
class HomeController : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model): String {
        model.addAttribute(
            "user",
            User(
                name = SecurityContextHolder.getContext().authentication.name,
                email = "evteev.vs36@gmail.com",
                rice = 15L,
                role = "CumRade",
                age = 21,
                weight = 80,
                height = 190,
                about = "yes"
            )
        )

        return model.moveNextOrGoHome("index")
    }
}