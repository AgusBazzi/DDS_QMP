package limpieza;

import prendas.Prenda;

public class Limpia extends Usable implements EstadoLimpieza {

  static final int LIMITE_LIMPIA = 2;

  public Limpia(Integer vecesUsada) {
    super(vecesUsada);
  }

  @Override
  public void cambiarEstado(Prenda unaPrenda) {
    if (getVecesUsada() >= LIMITE_LIMPIA) {
      unaPrenda.setEstadoLimpieza(new Sucia(0));
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
