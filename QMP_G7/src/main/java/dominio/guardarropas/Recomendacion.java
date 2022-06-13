package dominio.guardarropas;

import dominio.prendas.Prenda;

public abstract class Recomendacion {

  private Usuario recomendado;
  private Usuario recomendador;
  private Guardarropa guardarropasObjetivo;
  private Prenda prenda;

  public void enviar() {
    this.recomendado.recibirRecomendacion(this);
  }

  public abstract void aplicar();

  public abstract void deshacer();

  public Guardarropa getGuardarropasObjetivo() {
    return guardarropasObjetivo;
  }

  public Prenda getPrenda() {
    return prenda;
  }

}
