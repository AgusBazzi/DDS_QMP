package TestPrenda;

import dominio.prendas.BuilderPrenda;
import dominio.prendas.Prenda;
import dominio.prendas.TipoDePrendaEnum;
import dominio.prendas.Trama;
import servicios.AccuWeatherAPI;
import servicios.Clima;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestReqClimaticos {

  private Prenda unaPrenda;
  private Clima unClima;
  private AccuWeatherAPI aw;

  @Before
  public void crearReqClimaticos() throws Exception {
    BuilderPrenda builderPrenda = new BuilderPrenda(new Prenda());
    builderPrenda.buildTipo(TipoDePrendaEnum.REMERA);
    builderPrenda.buildMaterial("tela", Trama.LISA, "rojo", "negro");
    builderPrenda.buildReqClimaticos(18f, 26f);
    this.unaPrenda = builderPrenda.getResultado();

    this.unClima = new Clima();
  }

  @Test
  public void prendaRequiereQueHayaMayorTemperatura() throws Exception {
    this.unClima.setTemperatureF(16f);
    assertFalse(this.unaPrenda.esAcordeAClima(this.unClima));
  }

  @Test
  public void prendaRequiereQueHayaMenorTemperatura() throws Exception {
    this.unClima.setTemperatureF(28f);
    assertFalse(this.unaPrenda.esAcordeAClima(this.unClima));
  }

  @Test
  public void prendaEsAcordeALaTemperatura() throws Exception {
    this.unClima.setTemperatureF(22f);
    assertTrue(this.unaPrenda.esAcordeAClima(this.unClima));
  }

  @Test
  public void climaObtenidoParaBuenosAires() {
    aw = new AccuWeatherAPI();
    unClima = Clima.convertirAClima((HashMap<String, Object>) aw.getWeather("Buenos Aires").get(0));
    assertEquals(unClima.getTemperatureF(), 57F);
  }

}
