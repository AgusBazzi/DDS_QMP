package TestGuardarropa;

import atuendo.Guardarropa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prendas.BuilderPrenda;
import prendas.Prenda;
import prendas.TipoDePrendaEnum;
import prendas.Trama;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestGuardarropa {
  private Guardarropa unGuardarropa;
  private BuilderPrenda builderPrenda;

  @BeforeEach
  public void beforeTest() throws Exception {
    builderPrenda = new BuilderPrenda(new Prenda());
    unGuardarropa = new Guardarropa();
    builderPrenda.buildTipo(TipoDePrendaEnum.REMERA);
    builderPrenda.buildMaterial("Tela", Trama.A_CUADROS, "Rojo", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
    builderPrenda.buildTipo(TipoDePrendaEnum.REMERA);
    builderPrenda.buildMaterial("Lana", Trama.LISA, "Blanco", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
    builderPrenda.buildTipo(TipoDePrendaEnum.PANTALON);
    builderPrenda.buildMaterial("Algodon", Trama.RAYADA, "Negro", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
    builderPrenda.buildTipo(TipoDePrendaEnum.PANTALON);
    builderPrenda.buildMaterial("Lona", Trama.CON_LUNARES, "Azul", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
    builderPrenda.buildTipo(TipoDePrendaEnum.ZAPATO);
    builderPrenda.buildMaterial("Cuero", Trama.LISA, "Negro", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
    builderPrenda.buildTipo(TipoDePrendaEnum.ANTEOJOS);
    builderPrenda.buildMaterial("Policarbonato", Trama.LISA, "Dorado", null);
    unGuardarropa.addPrenda(builderPrenda.getResultado());
    builderPrenda.reset();
  }

  @Test
  public void elGuardarropaSeCreaCorrectamente() {
    assertNotNull(unGuardarropa);
  }

  @Test
  public void elGuardarropaAgregaPrendasCorrectamente() {
    assertEquals(unGuardarropa.getPrendas().size(), 6);
  }
}
