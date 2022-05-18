package TestGuardarropa;

import atuendo.Atuendo;
import atuendo.Guardarropa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prendas.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestGuardarropa {
  private Guardarropa unGuardarropa;
  private BuilderPrenda builderPrenda;

  @BeforeEach
  public void beforeTest() throws Exception {
    builderPrenda = new BuilderPrenda(new Prenda());
    unGuardarropa = new Guardarropa();
    this.crearPrenda(TipoDePrendaEnum.REMERA, "Tela", Trama.A_CUADROS, "Rojo");
    this.crearPrenda(TipoDePrendaEnum.REMERA, "Lana", Trama.LISA, "Blanco");
    this.crearPrenda(TipoDePrendaEnum.PANTALON, "Algodon", Trama.RAYADA, "Negro");
    this.crearPrenda(TipoDePrendaEnum.PANTALON, "Lona", Trama.CON_LUNARES, "Azul");
    this.crearPrenda(TipoDePrendaEnum.ZAPATO, "Cuero", Trama.LISA, "Negro");
    this.crearPrenda(TipoDePrendaEnum.ANTEOJOS, "Policarbonato", Trama.LISA, "Dorado");
  }

  private void crearPrenda(TipoDePrendaEnum tipo,
                             String unMaterial,
                             Trama unaTrama,
                             String unColorPrincipal) throws Exception {
    builderPrenda.buildTipo(tipo);
    builderPrenda.buildMaterial(unMaterial, unaTrama, unColorPrincipal, null);
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

  @Test
  public void elAtuendoSugeridoSinAccesoriosContieneSoloUnaPrendaDeCadaTipo() {
    Atuendo unAtuendoSugerido = unGuardarropa.crearSugerencia();
    assertEquals(unAtuendoSugerido.getPrendas().size(), 3);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_SUPERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_INFERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.CALZADO);
  }

  @Test
  public void elAtuendoSugeridoConAccesoriosContieneSoloUnaPrendaDeCadaTipo() {
    Atuendo unAtuendoSugerido = unGuardarropa.crearSugerenciaConAccesorio();
    assertEquals(unAtuendoSugerido.getPrendas().size(), 4);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_SUPERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_INFERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.CALZADO);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.ACCESORIO);
  }

  private void assertCategoriaUnica(Atuendo unAtuendo, Categoria categoria) {
    assertEquals(unAtuendo.getPrendas()
        .stream()
        .filter(prenda -> prenda.tieneCategoria(categoria))
        .count(), 1);
  }
}
