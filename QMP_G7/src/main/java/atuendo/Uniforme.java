package atuendo;

import excepciones.UniformeInvalidoException;
import prendas.Categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Uniforme extends Atuendo implements Cloneable {
  private String institucion;

  public Boolean esDeInstitucion(String unaInstitucion) {
    return unaInstitucion.equals(this.institucion);
  }

  public Uniforme clone() throws CloneNotSupportedException {
    return (Uniforme) super.clone();
  }

  public void validarUniformeCompleto() {
    if(!(super.getPrendas().size() == 3)) throw new UniformeInvalidoException();
    if(!this.validarCategorias())         throw new UniformeInvalidoException();
  }

  private Boolean validarCategorias() {
    List<Categoria> categoriasObligatorias = new ArrayList<Categoria>(Arrays.asList(Categoria.CALZADO,
                                                                                    Categoria.PARTE_INFERIOR,
                                                                                    Categoria.PARTE_SUPERIOR));

    return super.getPrendas()
        .stream()
        .map(prenda -> prenda.getCategoria())
        .collect(Collectors.toList())
        .containsAll(categoriasObligatorias);
  }
}
