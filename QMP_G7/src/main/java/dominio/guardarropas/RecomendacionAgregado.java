package dominio.guardarropas;

public class RecomendacionAgregado extends Recomendacion {

  @Override
  public void aplicar() {
    this.getGuardarropasObjetivo().addPrenda(this.getPrenda());
  }

  @Override
  public void deshacer() {
    this.getGuardarropasObjetivo().quitarPrenda(this.getPrenda());
  }
}
