package ussr.party.kabachki.partyportal.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import ussr.party.kabachki.partyportal.dto.WeatherDTO

@Service
class WeatherService {

    private val apiKey = "508dff1acdabb7268e658e51914a2567"
    private val openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}&units={units}"
    // TODO move to config

    fun getVoronezhWeatherData(): WeatherDTO {
        val webClient = WebClient.builder().build() // TODO: make bean with customizer
        return webClient.get()
            .uri(openWeatherUrl, "Voronezh", apiKey, "metric")
            .retrieve()
            .bodyToMono<WeatherDTO>()
            .block() ?: WeatherDTO()
    }


}