package TestPrenda;

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
  public void prendaSinTipoTiraExcepcionCorrecta() throws Exception {

    PrendaIncompletaException thrown = assertThrows(
        PrendaIncompletaException.class,
        () -> builder.getResultado(),
        "Esperaba que la getResultado() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! Es obligatorio el campo: tipo de prenda"));
  }

  @Test
  public void prendaSinColorPrincipalTiraExcepcionCorrecta() throws Exception {
    this.builder.buildTipo(TipoDePrendaEnum.PANTALON);
    this.builder.buildMaterial("tela", Trama.RAYADA, null, null);

    PrendaIncompletaException thrown = assertThrows(
        PrendaIncompletaException.class,
        () -> builder.getResultado(),
        "Esperaba que la getResultado() tire excepcion y no lo hizo."
    );
    Assert.assertTrue(thrown.getMessage().contains("La prenda no es valida! Es obligatorio el campo: color principal"));
  }

}