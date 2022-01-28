package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.dto.User
import ussr.party.kabachki.partyportal.repository.UserRepository

@Controller
class HomeController(
    private val userRepository: UserRepository
) : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model): String = model.moveNextOrGoHome("index")

    @ModelAttribute("user")
    fun initializeUser(model: Model) {
        val userEntity = userRepository.findByName(SecurityContextHolder.getContext().authentication.name)
        model.addAttribute(
            "user",
            User(
                name = userEntity.name,
                email = userEntity.email,
                rice = userEntity.rice,
                role = userEntity.role.toString(),
                age = userEntity.age,
                weight = userEntity.weight,
                height = userEntity.height,
                about = userEntity.about
            )
        )
    }
}