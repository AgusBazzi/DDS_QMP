package TestGuardarropa;

import dominio.atuendo.Atuendo;
import dominio.guardarropas.Guardarropa;
import dominio.prendas.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.AccuWeatherAPI;
import servicios.Clima;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGuardarropa {
  private Guardarropa unGuardarropa;
  private BuilderPrenda builderPrenda;
  private AccuWeatherAPI aw;
  private Clima unClima;

  @BeforeEach
  public void beforeTest() throws Exception {
    aw = new AccuWeatherAPI();
    unClima = Clima.convertirAClima((HashMap<String, Object>) aw.getWeather("Buenos Aires, Argentina").get(0));
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
    Atuendo unAtuendoSugerido = unGuardarropa.crearSugerencia(unClima);
    assertEquals(unAtuendoSugerido.getPrendas().size(), 3);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_SUPERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_INFERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.CALZADO);
  }

  @Test
  public void elAtuendoSugeridoConAccesoriosContieneSoloUnaPrendaDeCadaTipo() {
    Atuendo unAtuendoSugerido = unGuardarropa.crearSugerenciaConAccesorio(unClima);
    assertEquals(unAtuendoSugerido.getPrendas().size(), 4);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_SUPERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.PARTE_INFERIOR);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.CALZADO);
    this.assertCategoriaUnica(unAtuendoSugerido, Categoria.ACCESORIO);
  }
  @Test
  public void variasSugerenciasSeCreanCorrectamente() {
    List<Atuendo> variasSugerencias = unGuardarropa.variasSugerencias(3, unClima);
    assertEquals(variasSugerencias.size(), 3);
    variasSugerencias.forEach( atuendo -> { this.assertCategoriaUnica(atuendo, Categoria.PARTE_SUPERIOR);
                                            this.assertCategoriaUnica(atuendo, Categoria.PARTE_INFERIOR);
                                            this.assertCategoriaUnica(atuendo, Categoria.CALZADO);
                                            this.assertAccesorioUnicoOInexistente(atuendo); } );
  }

  private void assertCategoriaUnica(Atuendo unAtuendo, Categoria categoria) {
    assertEquals(unAtuendo.getPrendas()
        .stream()
        .filter(prenda -> prenda.tieneCategoria(categoria))
        .count(), 1);
  }

  private void assertAccesorioUnicoOInexistente(Atuendo unAtuendo) {
    Long cantAccesorios = unAtuendo.getPrendas()
                          .stream()
                          .filter( prenda -> prenda.tieneCategoria(Categoria.ACCESORIO)).count();
    assertTrue(cantAccesorios == 0 || cantAccesorios == 1);
  }
}
