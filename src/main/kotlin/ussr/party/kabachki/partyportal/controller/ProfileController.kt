package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/profile")
class ProfileController : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun profileHandler(model: Model) = model.moveNextOrGoHome("profile/index")
}