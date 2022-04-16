package TestPrenda;

import org.junit.Assert;
import org.junit.Test;

import prendas.Categoria;
import prendas.Prenda;
import prendas.TipoPrenda;


public class TestCreacionPrenda {

    @Test
    public void crearPrendaConAtributosNecesarios() throws Exception {
        Prenda nuevaPrenda4 = new Prenda(Categoria.PARTE_INFERIOR, TipoPrenda.PANTALON, "tela", "rojo");
        Prenda nuevaPrenda5 = new Prenda(Categoria.PARTE_INFERIOR, TipoPrenda.PANTALON, "tela", "rojo", "bordo");

        Assert.assertNotEquals(nuevaPrenda4, nuevaPrenda5);
    }

    @Test
    public void noExisteCamisaComoCalzado() throws Exception {

        try {
            Prenda nuevaPrenda4 = new Prenda(Categoria.CALZADO, TipoPrenda.CAMISA, "tela", "rojo");
        } catch(Exception e) {
            Assert.assertTrue(true);
            return;
        }

        Assert.assertTrue(false);
    }

}
