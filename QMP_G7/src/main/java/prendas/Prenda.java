package prendas;

import excepciones.PrendaIncompletaException;
import limpieza.*;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private Material material;
    private EstadoLimpieza estadoLimpieza;

    // --- Setters --- //

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public void validarAtributosCompletos() throws PrendaIncompletaException {
        this.validarTipoPrendaNoVacio();
        this.validarMaterialNoVacio();
        this.material.validarAtributosCompletos();
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
        return this.tipoPrenda.tieneCategoria(unaCategoria);
    }

    public Categoria getCategoria() {
        return this.tipoPrenda.getCategoria();
    }

    public TipoDePrendaEnum getTipoDePrenda() {
        return tipoPrenda.getTipoDePrenda();
    }

    public Material getMaterial() {
        return material;
    }

    public void setEstadoLimpieza() {
        this.estadoLimpieza = new Limpia(0);
    }

    public EstadoLimpieza getEstadoLimpieza() {
        return this.estadoLimpieza;
    }

    public void setPrendaSucia() {
        this.estadoLimpieza = new Sucia(0);
    }

    public void setPrendaLimpia() {
        this.estadoLimpieza = new Limpia(0);
    }

    public void setPrendaPercudida() {
        this.estadoLimpieza = new Percudida();
    }

    public void setPrendaLavandose() {
        this.estadoLimpieza = new Lavandose();
    }

    public void utilizarPrenda() {

        //TODO: implementar el uso de la prenda, cuando se hace la sugerencia
    }
}