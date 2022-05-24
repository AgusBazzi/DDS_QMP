package servicios;

public class Clima {

  private String dateTime;
  private String phrase;
  private Boolean isDayLight;
  private Float precipitationProbability;
  private Float  temperatureF;

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
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
}
