package limpieza;

import prendas.Prenda;

public class Lavandose implements EstadoLimpieza {

  @Override
  public void cambiarEstado(Prenda unaPrenda, EstadoLimpieza estadoLimpieza) {
    //TODO
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return false;
  }

  @Override
  public void serUsada(Prenda unaPrenda) {
    //TODO Exception
  }

  public void terminarDeLavarse(Prenda unaPrenda) {
    unaPrenda.setEstadoLimpieza(new Limpia(0));
  }
}
