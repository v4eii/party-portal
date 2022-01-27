package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.dto.InitialRequestDTO

@Controller
@RequestMapping("/initial-request")
class InitialRequestController : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model, @ModelAttribute("user") user: String): String {
        model.addAttribute("initialRequest", InitialRequestDTO(initiator = user))

        return "initial-request/index.html"
    }

    @PostMapping("/new")
    fun createRequest(@ModelAttribute initialRequestDTO: InitialRequestDTO): String {
        println(initialRequestDTO)

        return "index"
    }
}