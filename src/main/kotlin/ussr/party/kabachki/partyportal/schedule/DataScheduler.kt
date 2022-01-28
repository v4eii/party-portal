package ussr.party.kabachki.partyportal.schedule

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ussr.party.kabachki.partyportal.dto.WeatherDTO
import ussr.party.kabachki.partyportal.service.WeatherService

@Component
@EnableScheduling
class DataScheduler(
    private val weatherService: WeatherService
) {
    var weatherDTO: WeatherDTO = WeatherDTO()

    @Scheduled(fixedRate = 300000L) // 5 min, move to config
    fun updateWeatherAttribute() {
        weatherDTO = weatherService.getVoronezhWeatherData()
    }
}