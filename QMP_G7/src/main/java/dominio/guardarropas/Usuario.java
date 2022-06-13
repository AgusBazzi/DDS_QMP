package dominio.guardarropas;

import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

  private String usuario;
  private String contrasenia;
  private List<Guardarropa> guardarropas;

  public void agregarUnGuardarropas(Guardarropa unGuardarropa) {
    this.guardarropas.add(unGuardarropa);
  }

  public void compartirUnGuardarropas(Guardarropa unGuardarropa, Usuario unUsuario) {
    if(this.guardarropas.contains(unGuardarropa)) {
      unUsuario.agregarUnGuardarropas(unGuardarropa);
    }
  }

  public List<Recomendacion> verMisRecomendaciones() {
    return this.guardarropas
        .stream()
        .flatMap( g -> g.verMisRecomendaciones)
        .collect(Collectors.toList());
  }

}
