package limpieza;

import prendas.Prenda;

public class Percudida implements EstadoLimpieza {

  @Override
  public void cambiarEstado(Prenda unaPrenda, EstadoLimpieza estadoLimpieza) {
    //TODO Exception
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return false;
  }

  @Override
  public void serUsada(Prenda unaPrenda) {
    //TODO Exception
  }
}
