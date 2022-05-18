package limpieza;

import prendas.Prenda;

public class Percudida implements EstadoLimpieza {

  @Override
  public void cambiarEstado(Prenda unaPrenda) {
    //TODO: no puede cambiar de estado
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return false;
  }
}
