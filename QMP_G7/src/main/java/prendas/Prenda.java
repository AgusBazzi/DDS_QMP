package prendas;

import com.sun.org.apache.xpath.internal.operations.Bool;
import excepciones.PrendaIncompatibleException;
import excepciones.PrendaIncompletaException;

public class Prenda {

    private Categoria categoria;
    private TipoPrenda tipoPrenda;
    private Material material;

    private static String[] atributosObligatorios = {"categoria", "tipoPrenda", "material"};


    // --- Setters --- //

    public void setCategoria(Categoria categoria) throws Exception {
        if (this.esCompatible(categoria, this.tipoPrenda)) {
            this.categoria = categoria;
        }
        else {
            throw new PrendaIncompatibleException();
        }
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) throws Exception {
        if (this.esCompatible(this.categoria, tipoPrenda)) {
            this.tipoPrenda = tipoPrenda;
        }
        else {
            throw new PrendaIncompatibleException();
        }
    }

    private Boolean esCompatible(Categoria categoria, TipoPrenda tipoPrenda) {
        Compatibilidades diccionario = Compatibilidades.getInstance();
        return diccionario.esValido(categoria, tipoPrenda);
    }

    public void validarAtributosCompletos() throws PrendaIncompletaException, NoSuchFieldException, IllegalAccessException {

        for(String campo : atributosObligatorios) {
            if(this.getClass().getDeclaredField(campo).get(this) == null) throw new PrendaIncompletaException(campo);
        }

        this.material.validarAtributosCompletos();
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Boolean tieneCategoria(Categoria unaCategoria) {
        return this.categoria.equals(unaCategoria);
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
}