package limpieza;

import prendas.Prenda;

public abstract class Usable implements EstadoLimpieza {
  private Integer vecesUsada;

  public Usable(Integer vecesUsada) {
    this.vecesUsada = vecesUsada;
  }

  public abstract Integer getLimite();

  public Integer getVecesUsada() {
    return vecesUsada;
  }

  public abstract EstadoLimpieza siguienteEstado();

  public void serUsada(Prenda unaPrenda) {
    this.vecesUsada++;
    this.chequearCambioEstado(unaPrenda);
  }

  public void serLavada(Prenda unaPrenda) {
    this.vecesUsada = 0;
    unaPrenda.setEstadoLimpieza(new Lavandose());
  }

  @Override
  public void cambiarEstado(Prenda unaPrenda, EstadoLimpieza estadoLimpieza) {
    unaPrenda.setEstadoLimpieza(estadoLimpieza);
  }

  @Override
  public Boolean puedeSerSugerida(Prenda unaPrenda) {
    return true;
  }

  public void chequearCambioEstado(Prenda unaPrenda) {
    if(getVecesUsada() >= this.getLimite()) {
      this.cambiarEstado(unaPrenda, this.siguienteEstado());
    }
  }
}
