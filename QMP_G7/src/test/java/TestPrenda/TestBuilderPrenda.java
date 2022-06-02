package TestPrenda;

import dominio.prendas.*;
import org.junit.Before;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBuilderPrenda {

  private BuilderPrenda builder;
  Prenda prendaResultado;

  @Before
  public void beforeTest() throws Exception {
    this.builder = new BuilderPrenda(new Prenda());
    this.builder.buildTipo(TipoDePrendaEnum.REMERA);
    this.builder.buildMaterial("tela",null,"rojo","amarillo");
    prendaResultado = this.builder.getResultado();
  }

  @Test
  public void builderAgregaCategoriaCorrectamente() {
    assertEquals(Categoria.PARTE_SUPERIOR,prendaResultado.getCategoria());
  }

  @Test
  public void builderAgregaTipoCorrectamente() {
    assertEquals(TipoDePrendaEnum.REMERA,prendaResultado.getTipoDePrenda());
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
