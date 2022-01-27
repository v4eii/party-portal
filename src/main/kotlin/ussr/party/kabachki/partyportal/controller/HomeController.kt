package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model): String {
        model.addAttribute("user", "${Math.random()}")

        return "index"
    }
}