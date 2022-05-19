package limpieza;

import prendas.Prenda;

public class Lavandose implements EstadoLimpieza {

  @Override
  public void cambiarEstado(Prenda unaPrenda) {
    //TODO:
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return true;
  }

  public void terminarDeLavarse(Prenda unaPrenda) {
    unaPrenda.setEstadoLimpieza(new Limpia(0));
  }
}
