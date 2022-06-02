package servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Clima {

  private LocalDateTime dateTime;
  private String phrase;
  private Boolean isDayLight;
  private Float precipitationProbability;
  private Float temperatureF;

  public String getDateTime() {
    return dateTime.toString();
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getPhrase() {
    return phrase;
  }

  public void setPhrase(String phrase) {
    this.phrase = phrase;
  }

  public Boolean getDayLight() {
    return isDayLight;
  }

  public void setDayLight(Boolean dayLight) {
    isDayLight = dayLight;
  }

  public Float getPrecipitationProbability() {
    return precipitationProbability;
  }

  public void setPrecipitationProbability(Float precipitationProbability) {
    this.precipitationProbability = precipitationProbability;
  }

  public Float getTemperatureF() {
    return temperatureF;
  }

  public void setTemperatureF(Float temperatureF) {
    this.temperatureF = temperatureF;
  }

  public static Clima convertirAClima(HashMap<String, Object> rawData) {
    Clima nuevoClima = new Clima();
    nuevoClima.setDateTime(LocalDateTime.parse(rawData.get("DateTime").toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME));
    nuevoClima.setPhrase(rawData.get("IconPhrase").toString());
    nuevoClima.setDayLight((Boolean) rawData.get("IsDaylight"));
    nuevoClima.setPrecipitationProbability(Float.valueOf(rawData.get("PrecipitationProbability").toString()));
    nuevoClima.setTemperatureF(Float.valueOf(((HashMap) rawData.get("Temperature")).get("Value").toString()));
    return nuevoClima;
  }
}
