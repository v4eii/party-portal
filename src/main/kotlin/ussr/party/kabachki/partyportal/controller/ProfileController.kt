package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/profile")
class ProfileController : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun profileHandler(
        @ModelAttribute("user")
        username: String,
        model: Model
    ): String {
        model.addAttribute("username", username)
        model.addAttribute("role", "cumrade")
        model.addAttribute("rice", "1")

        return "profile/index"
    }
}