package ussr.party.kabachki.partyportal.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler() = "index"
}