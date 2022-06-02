package dominio.prendas;

import servicios.Clima;

public class ReqClimaticos {

  private Float temperaturaMaxF;
  private Float temperaturaMinF;

  // Por el momento solo valida la temperatura, que es lo que pide el enunciado.
  // Realizar otras validaciones aqui si se quieren agregar.
  public Boolean esAcordeAClima(Clima unClima) {
    return
        unClima.getTemperatureF() < this.temperaturaMaxF &&
        unClima.getTemperatureF() > this.temperaturaMinF;
  }

  public void setTemperaturaMinF(Float temperaturaMinF) {
    this.temperaturaMinF = temperaturaMinF;
  }

  public void setTemperaturaMaxF(Float temperaturaMaxF) {
    this.temperaturaMaxF = temperaturaMaxF;
  }

}
