package atuendo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Negocio {
  private List<Uniforme> uniformes = new ArrayList<Uniforme>();

  public void agregarUniforme(Uniforme unUniforme) {
    this.uniformes.add(unUniforme);
  }

  public Uniforme getUniforme(String unaInstitucion) throws Exception {
    Uniforme uniformeBuscado = this.uniformes.stream().
        filter(uniforme -> uniforme.esDeInstitucion(unaInstitucion)).
        collect(Collectors.toList()).
        stream().
        findFirst().orElse(null);
    if(uniformeBuscado.equals(null)) {
      throw new Exception("No existe un uniforme para esta institucion");
    } else {
      return uniformeBuscado.clone();
    }
  }
}
