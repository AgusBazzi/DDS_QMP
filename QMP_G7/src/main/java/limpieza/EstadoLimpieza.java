package limpieza;

import prendas.Prenda;

public interface EstadoLimpieza {

  void cambiarEstado(Prenda unaPrenda);

  Boolean puedeSerSugerida(Prenda unaPrenda);

}
