package ussr.party.kabachki.partyportal.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherDTO(
    var id: Int = 0, // City ID
    var weather: ArrayList<Weather>? = null,
    var coordinate: Coordinate? = null,
    var main: Main = Main(),
    var visibility: Int = 0, // Visibility, meter
    var wind: Wind? = null,
    var snow: Snow? = null,
    var clouds: Clouds? = null,
    var dt: Int = 0, // Time of data calculation, unix, UTC
    var sys: Sys? = null,
    var timezone: Int = 0, // Shift in seconds from UTC
    var name: String? = null, // City name
)

data class Coordinate(
    var lon: Double = 0.0, // geo location, longitude
    var lat: Double = 0.0 // geo location, latitude
)

data class Weather(
    var id: Int = 0, // condition id
    var main: String? = null, // weather parameters (Rain, Snow, Extreme etc.)
    var description: String? = null,
    var icon: String? = null // icon id
)

data class Main(
    var temp: Double = 0.0, // Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    var feelsLike: Double = 0.0, // This temperature parameter accounts for the human perception of weather.
    var tempMin: Double = 0.0, // Minimum temperature at the moment.
    var tempMax: Double = 0.0, // Maximum temperature at the moment
    var pressure: Int = 0, // Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
    var humidity: Int = 0 // Humidity, %
)

data class Wind(
    var speed: Int = 0, // Unit Default: meter/sec
    var deg: Int = 0 // Wind direction, degrees (meteorological)
)

class Snow(
    @JsonProperty("1h")
    var h1: Double = 0.0 // Snow volume for the last 1 hour, mm
)

class Clouds(
    var all: Int = 0 // Cloudiness, %
)

class Sys(
    var country: String? = null, // Country code
    var sunrise: Int = 0, // Sunrise time, unix, UTC
    var sunset: Int = 0 // Sunset time, unix, UTC
)