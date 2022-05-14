package prendas;

import excepciones.PrendaIncompatibleException;
import excepciones.PrendaIncompletaException;

public class Prenda {

    private Categoria categoria;
    private TipoPrenda tipoPrenda;
    private Material material;

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

    public void validarAtributosCompletos() throws PrendaIncompletaException {
        this.validarCategoriaNoVacia();
        this.validarTipoPrendaNoVacio();
        this.validarMaterialNoVacio();
        this.material.validarAtributosCompletos();
    }

    private void validarCategoriaNoVacia() {
        if(chequearVacio(this.categoria))   throw new PrendaIncompletaException("categoria");
    }

    private void validarTipoPrendaNoVacio() {
        if(chequearVacio(this.tipoPrenda))   throw new PrendaIncompletaException("tipo de prenda");
    }

    private void validarMaterialNoVacio() {
        if(chequearVacio(this.material))   throw new PrendaIncompletaException("material");
    }

    private Boolean chequearVacio(Object atributoDePrenda){
        return atributoDePrenda == null;
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

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Material getMaterial() {
        return material;
    }
}