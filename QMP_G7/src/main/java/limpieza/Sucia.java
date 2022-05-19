package limpieza;

import prendas.Prenda;

public class Sucia extends Usable implements EstadoLimpieza {
  static final int LIMITE_SUCIA = 3;

  public Sucia(Integer vecesUsada) {
    super(vecesUsada);
  }

  @Override
  public void cambiarEstado(Prenda unaPrenda) {
    if (getVecesUsada() >= LIMITE_SUCIA) {
      unaPrenda.setEstadoLimpieza(new Percudida());
    } else {
      unaPrenda.setEstadoLimpieza(new Lavandose());
    }
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return true;
  }

  @Override
  public EstadoLimpieza chequearEstado(Prenda unaPrenda) {
    return unaPrenda.getEstadoLimpieza();
  }
}
