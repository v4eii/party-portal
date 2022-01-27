package ussr.party.kabachki.partyportal.controller

import org.springframework.boot.info.BuildProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/about")
class AboutController(
    private val buildProperties: BuildProperties
) {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun aboutHandler(model: Model): String {
        model.addAttribute("buildInfo", buildProperties)

        return "about/index"
    }

}