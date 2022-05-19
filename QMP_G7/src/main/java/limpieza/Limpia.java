package limpieza;

import prendas.Prenda;

public class Limpia extends Usable {

  static final Integer LIMITE_LIMPIA = 2;

  public Integer getLimite(){
    return LIMITE_LIMPIA;
  }

  @Override
  public EstadoLimpieza siguienteEstado() {
    return new Sucia(0);
  }

  public Limpia(Integer vecesUsada) {
    super(vecesUsada);
  }
}
