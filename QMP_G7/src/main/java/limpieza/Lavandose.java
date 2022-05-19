package limpieza;

import prendas.Prenda;

public class Lavandose implements EstadoLimpieza {

  @Override
  public void cambiarEstado(Prenda unaPrenda, EstadoLimpieza estadoLimpieza) {
    unaPrenda.setEstadoLimpieza(estadoLimpieza);
  }

  @Override
  public Boolean puedeSerSugerida() {
    return false;
  }

  @Override
  public void serUsada(Prenda unaPrenda) {
    //TODO Exception
  }

  @Override
  public void serLavada(Prenda prenda) {
    //TODO
  }

  public void terminarDeLavarse(Prenda unaPrenda) {
    this.cambiarEstado(unaPrenda, new Limpia(0));
  }
}
