package TestPrenda;

import excepciones.PrendaIncompatibleException;
import excepciones.PrendaIncompletaException;
import org.junit.Before;
import prendas.*;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestExcepcionesPrenda {

  private BuilderPrenda builder;

  @Before
  public void beforeTest() {
    this.builder = new BuilderPrenda(new Prenda());
  }

  @Test
  public void prendaSinCategoriaTiraExcepcionCorrecta() {
    PrendaIncompletaException thrown = assertThrows(
        PrendaIncompletaException.class,
        () -> builder.getResultado(),
        "Esperaba que la getResultado() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! Es obligatorio el campo: categoria"));
  }

  @Test
  public void prendaSinTipoTiraExcepcionCorrecta() throws Exception {

    this.builder.buildCategoria(Categoria.PARTE_INFERIOR);

    PrendaIncompletaException thrown = assertThrows(
        PrendaIncompletaException.class,
        () -> builder.getResultado(),
        "Esperaba que la getResultado() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! Es obligatorio el campo: tipo de prenda"));
  }

  @Test
  public void prendaSinColorPrincipalTiraExcepcionCorrecta() throws Exception {

    this.builder.buildCategoria(Categoria.PARTE_INFERIOR);
    this.builder.buildTipo(TipoPrenda.PANTALON);
    this.builder.buildMaterial("tela", Trama.RAYADA, null, null);

    PrendaIncompletaException thrown = assertThrows(
        PrendaIncompletaException.class,
        () -> builder.getResultado(),
        "Esperaba que la getResultado() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! Es obligatorio el campo: color principal"));
  }

  @Test
  public void prendaCamisaNoEsPrendaInferior() throws Exception {

    this.builder.buildCategoria(Categoria.PARTE_INFERIOR);

    PrendaIncompatibleException thrown = assertThrows(
        PrendaIncompatibleException.class,
        () -> builder.buildTipo(TipoPrenda.CAMISA),
        "Esperaba que la buildTipo() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! El tipo y categoria no son compatibles."));
  }

  @Test
  public void prendaPantalonNoEsPrendaInferior() throws Exception {

    this.builder.buildTipo(TipoPrenda.PANTALON);

    PrendaIncompatibleException thrown = assertThrows(
        PrendaIncompatibleException.class,
        () -> builder.buildCategoria(Categoria.PARTE_SUPERIOR),
        "Esperaba que la buildTipo() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! El tipo y categoria no son compatibles."));
  }

}