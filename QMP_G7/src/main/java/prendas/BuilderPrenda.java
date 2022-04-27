package prendas;

import excepciones.PrendaIncompletaException;

public class BuilderPrenda {

  private Prenda resultado;

  public BuilderPrenda(Prenda unaPrenda) {
    this.resultado = unaPrenda;
  }

  public void buildTipo(TipoPrenda tipoPrenda) throws Exception {
    this.resultado.setTipoPrenda(tipoPrenda);
  }

  public void buildCategoria(Categoria categoria) throws Exception {
    this.resultado.setCategoria(categoria);
  }

  public void buildMaterial(String nombreMaterial, Trama trama, String colorPrincipal, String colorSecundario) {
    Material material = new Material();
    material.setNombre(nombreMaterial);
    material.setTrama(trama);
    material.setColorPrincipal(colorPrincipal);
    material.setColorSecundario(colorSecundario);
    this.resultado.setMaterial(material);
  }

  public Prenda getResultado() throws PrendaIncompletaException, NoSuchFieldException, IllegalAccessException {
      this.resultado.validarAtributosCompletos();
      return this.resultado;
  }

  public void reset() {
    this.resultado = new Prenda();
  }

}
