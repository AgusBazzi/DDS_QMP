package dominio.prendas;

import excepciones.PrendaIncompletaException;
import servicios.Clima;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private Material material;
    private ReqClimaticos reqClimaticos;

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

    public Boolean esAcordeAClima(Clima unClima) {
        try {
            return this.reqClimaticos.esAcordeAClima(unClima);
        } catch (Exception e) {
            return true;
            // Si no se cargan los requerimientos, por default se puede usar.
            // No quiero convertirlo en atributo obligatorio (no le veo sentido)
        }
    }

    public void setReqClimaticos(ReqClimaticos reqClimaticos) {
        this.reqClimaticos = reqClimaticos;
    }

  public Boolean esAptaParaSerSugerible(Categoria unaCategoria, Clima unClima) {
        return tieneCategoria(unaCategoria) && esAcordeAClima(unClima);
  }
}