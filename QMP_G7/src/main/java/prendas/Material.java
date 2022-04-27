package prendas;

import excepciones.PrendaIncompletaException;

public class Material {

  private String nombre;
  private Trama trama;
  private String colorPrincipal;
  private String colorSecundario;

  private static String[] atributosObligatorios = {"nombre", "colorPrincipal"};

  public void setTrama(Trama trama) {
    if(trama == null)  this.trama = Trama.LISA;
    else               this.trama = trama;
  }

  public void setColorPrincipal(String colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(String colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setNombre(String nombreMaterial) {
    this.nombre = nombreMaterial;
  }

  public void validarAtributosCompletos() throws NoSuchFieldException, IllegalAccessException {
    for(String campo : atributosObligatorios) {
      if(this.getClass().getDeclaredField(campo).get(this) == null) throw new PrendaIncompletaException(campo);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public Trama getTrama() {
    return trama;
  }

  public String getColorPrincipal() {
    return colorPrincipal;
  }

  public String getColorSecundario() {
    return colorSecundario;
  }
}
