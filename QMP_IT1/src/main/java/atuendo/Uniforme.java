package atuendo;

public class Uniforme extends Atuendo {
  private String institucion;

  public Boolean esDeInstitucion(String unaInstitucion) {
    return unaInstitucion.equals(this.institucion);
  }

  public Uniforme clonarUniforme() throws CloneNotSupportedException {
    //return this.clone();
    return this;
  }
}
