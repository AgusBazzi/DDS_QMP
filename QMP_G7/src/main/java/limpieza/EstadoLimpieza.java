package limpieza;

import prendas.Prenda;

public interface EstadoLimpieza {

  void cambiarEstado(Prenda unaPrenda, EstadoLimpieza estadoLimpieza);

  Boolean puedeSerSugerida();

  void serUsada(Prenda unaPrenda);

  void serLavada(Prenda prenda);

  void terminarDeLavarse(Prenda prenda);
}
