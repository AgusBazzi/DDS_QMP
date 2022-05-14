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

  public void validarAtributosCompletos() {
    this.validarNombreNoVacio();
    this.validarColorPrincipalNoVacio();
  }

  private void validarNombreNoVacio() {
    if(chequearVacio(this.nombre))   throw new PrendaIncompletaException("material");
  }

  private void validarColorPrincipalNoVacio() {
    if(chequearVacio(this.colorPrincipal))   throw new PrendaIncompletaException("color principal");
  }

  private Boolean chequearVacio(Object atributoDePrenda){
    return atributoDePrenda == null;
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
