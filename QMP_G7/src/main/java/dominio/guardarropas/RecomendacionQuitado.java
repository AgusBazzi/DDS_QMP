package dominio.guardarropas;

public class RecomendacionQuitado extends Recomendacion {

  @Override
  public void aplicar() {
    this.getGuardarropasObjetivo().quitarPrenda(this.getPrenda());
  }

  @Override
  public void deshacer() {
    this.getGuardarropasObjetivo().addPrenda(this.getPrenda());
  }
}
