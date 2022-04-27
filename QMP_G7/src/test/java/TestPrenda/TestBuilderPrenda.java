package TestPrenda;

import org.junit.Before;
import prendas.*;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBuilderPrenda {

  private BuilderPrenda builder;
  Prenda prendaResultado;

  @Before
  public void beforeTest() throws Exception {
    this.builder = new BuilderPrenda(new Prenda());
    this.builder.buildCategoria(Categoria.PARTE_SUPERIOR);
    this.builder.buildTipo(TipoPrenda.CAMISA);
    this.builder.buildMaterial("tela",null,"rojo","amarillo");
    prendaResultado = this.builder.getResultado();
  }

  @Test
  public void builderAgregaCategoriaCorrectamente() {
    assertEquals(Categoria.PARTE_SUPERIOR,prendaResultado.getCategoria());
  }

  @Test
  public void builderAgregaTipoCorrectamente() {
    assertEquals(TipoPrenda.CAMISA,prendaResultado.getTipoPrenda());
  }

  @Test
  public void builderAgregaNombreMaterialCorrectamente() {
    assertEquals("tela",prendaResultado.getMaterial().getNombre());
  }

  @Test
  public void builderAgregaTramaCorrectamente() {
    assertEquals(Trama.LISA,prendaResultado.getMaterial().getTrama());
  }

  @Test
  public void builderAgregaColorPrincipalCorrectamente() {
    assertEquals("rojo",prendaResultado.getMaterial().getColorPrincipal());
  }

  @Test
  public void builderAgregaColorSecundarioCorrectamente() {
    assertEquals("amarillo",prendaResultado.getMaterial().getColorSecundario());
  }

}
