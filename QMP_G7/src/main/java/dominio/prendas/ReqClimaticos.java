package dominio.prendas;

import servicios.Clima;

public class ReqClimaticos {

  private Integer temperaturaMaxF;
  private Integer temperaturaMinF;

  // Por el momento solo valida la temperatura, que es lo que pide el enunciado.
  // Realizar otras validaciones aqui si se quieren agregar.
  public Boolean esAcordeAClima(Clima unClima) {
    return
        unClima.getTemperatureF() < this.temperaturaMaxF &&
        unClima.getTemperatureF() > this.temperaturaMinF;
  }

  public void setTemperaturaMinF(Integer temperaturaMinF) {
    this.temperaturaMinF = temperaturaMinF;
  }

  public void setTemperaturaMaxF(Integer temperaturaMaxF) {
    this.temperaturaMaxF = temperaturaMaxF;
  }

}
