package atuendo;

public class Uniforme extends Atuendo implements Cloneable {
  private String institucion;

  public Boolean esDeInstitucion(String unaInstitucion) {
    return unaInstitucion.equals(this.institucion);
  }

  public Uniforme clone() throws CloneNotSupportedException {
    return (Uniforme) super.clone();
  }
}
