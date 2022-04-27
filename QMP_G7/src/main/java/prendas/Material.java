package prendas;

public class Material {
  private String nombre;
  private Trama trama;
  private String colorPrincipal;
  private String colorSecundario;

  public Boolean estoyListo() {
    return !this.nombre.equals(null) && !this.colorPrincipal.equals(null);
  }

  public void setTrama(Trama trama) {
    if(trama.equals(null))  this.trama = Trama.LISA;
    else                    this.trama = trama;
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
}
