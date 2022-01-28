package ussr.party.kabachki.partyportal.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import ussr.party.kabachki.partyportal.schedule.DataScheduler
import ussr.party.kabachki.partyportal.service.UserService
import ussr.party.kabachki.partyportal.service.WeatherService

@Controller
class HomeController(
    private val userService: UserService,
    private val weatherService: WeatherService,
    private val dataScheduler: DataScheduler
) : SessionAttributeController {

    @RequestMapping(path = ["", "/", "index", "index.html"])
    fun indexHandler(model: Model): String =
        model.updateTemperatureAttribute(dataScheduler)
            .moveNextOrGoHome("index")

    @ModelAttribute("user")
    fun initializeUser(model: Model) {
        model.addAttribute(
            "user",
            userService.getUser(SecurityContextHolder.getContext().authentication.name)
        )
    }

    @ModelAttribute("weather")
    fun initializeWeather(model: Model) {
        model.addAttribute(
            "weather",
            weatherService.getVoronezhWeatherData()
        )
    }
}