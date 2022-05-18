package limpieza;

import prendas.Prenda;

public abstract class Usable {
  private Integer vecesUsada;

  public Usable(Integer vecesUsada) {
    this.vecesUsada = vecesUsada;
  }

  public Integer getVecesUsada() {
    return vecesUsada;
  }

  public void serUsada() {
    aumentarVecesUsadas();
  }

  public void aumentarVecesUsadas() {
    this.vecesUsada++;
  }

  public void serLavada(Prenda unaPrenda) {
    this.vecesUsada = 0;
    unaPrenda.setPrendaLavandose();
  }

  abstract EstadoLimpieza chequearEstado(Prenda unaPrenda);
}
