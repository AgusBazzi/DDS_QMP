package atuendo;

import prendas.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {

  private List<Prenda> prendas;

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void agregarPrenda(Prenda unaPrenda) {
    this.prendas.add(unaPrenda);
  }

  public Atuendo() {
    this.prendas = new ArrayList<>();
  }

  public void serUsado() {
    prendas.forEach(prenda -> prenda.serUsada());
  }
}
