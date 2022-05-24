package dominio.atuendo;

import excepciones.PrendaDeUniformeIncorrectaException;
import dominio.prendas.Categoria;
import dominio.prendas.Prenda;

public class BuilderUniforme {
  
  private Uniforme resultado = new Uniforme();

  private void buildPrenda(Prenda unaPrenda, Categoria unaCategoria) {
    if(unaPrenda.tieneCategoria(unaCategoria)) this.resultado.agregarPrenda(unaPrenda);
    else  throw new PrendaDeUniformeIncorrectaException(unaCategoria.toString());
  }

  public void buildSuperior(Prenda prendaSuperior) {
    buildPrenda(prendaSuperior, Categoria.PARTE_SUPERIOR);
  }

  public void buildInferior(Prenda prendaInferior) {
    buildPrenda(prendaInferior, Categoria.PARTE_INFERIOR);
  }

  public void buildCalzado(Prenda prendaCalzado) {
    buildPrenda(prendaCalzado, Categoria.CALZADO);
  }

  public Uniforme getResultado() {

    return this.resultado;
  }

  public void reset() {
    this.resultado = new Uniforme();
  }
}
