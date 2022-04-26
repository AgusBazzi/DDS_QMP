package prendas;

public class BuilderPrenda {
  private Prenda resultado = new Prenda();

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

  public Prenda getResultado() throws Exception {
    if(this.resultado.estoyListo()) {
      return this.resultado;
    } else {
      throw new Exception("La prenda no esta completa");
    }
  }

}
