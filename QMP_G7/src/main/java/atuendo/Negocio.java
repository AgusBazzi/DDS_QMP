package atuendo;

import java.util.*;
import java.util.stream.Collectors;

public class Negocio {
  private List<Uniforme> uniformes;
  private static Negocio instance;

  public void agregarUniforme(Uniforme unUniforme) {
    this.uniformes.add(unUniforme);
  }

  private Negocio(){};

  public static Negocio getInstance() {
    if(instance == null) {
      instance = new Negocio();
      instance.uniformes = new ArrayList<>();
    }
    return instance;
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
