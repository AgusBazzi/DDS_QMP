package limpieza;

import prendas.Prenda;

public class Sucia extends Usable {
  static final Integer LIMITE_SUCIA = 3;

  public Integer getLimite(){
    return LIMITE_SUCIA;
  }

  @Override
  public EstadoLimpieza siguienteEstado() {
    return new Percudida();
  }

  public Sucia(Integer vecesUsada) {
    super(vecesUsada);
  }
}
