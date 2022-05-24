package servicios;

import java.util.*;

public final class AccuWeatherAPI {

  // Nota: no usa la API realmente, pero es el codigo que se nos entrego.

  public final List<Map<String, Object>> getWeather(String ciudad) {
    return Arrays.asList(new HashMap<String, Object>(){{
      put("DateTime", "2019-05-03T01:00:00-03:00");
      put("EpochDateTime", 1556856000);
      put("WeatherIcon", 33);
      put("IconPhrase", "Clear");
      put("IsDaylight", false);
      put("PrecipitationProbability", 0);
      put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
      put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
      put("Temperature", new HashMap<String, Object>(){{
        put("Value", 57);
        put("Unit", "F");
        put("UnitType", 18);
      }});
    }});
  }

  // Puede que sea horrible, but it is what it is. Abierto a cambios.
  public Clima convertirAClima(HashMap<String, Object> rawData) {
    Clima nuevoClima = new Clima();
    nuevoClima.setDateTime(rawData.get("DateTime").toString());
    nuevoClima.setPhrase(rawData.get("IconPhrase").toString());
    nuevoClima.setDayLight((Boolean) rawData.get("IsDaylight"));
    nuevoClima.setPrecipitationProbability((Float) rawData.get("PrecipitationProbability"));
    nuevoClima.setTemperatureF((Float) ((HashMap) rawData.get("Temperature")).get("Value") );
    return nuevoClima;
  }
}
