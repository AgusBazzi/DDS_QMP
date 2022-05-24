package dominio.prendas;

import excepciones.PrendaIncompletaException;

public class BuilderPrenda {

  private Prenda resultado;

  public BuilderPrenda(Prenda unaPrenda) {
    this.resultado = unaPrenda;
  }

  public void buildTipo(TipoDePrendaEnum tipoDePrenda) throws Exception {
    TipoPrenda tipoAAsignar = null;
    switch(tipoDePrenda) {
      case REMERA:
        tipoAAsignar = TipoPrenda.crearRemera();
        break;
      case ZAPATO:
        tipoAAsignar = TipoPrenda.crearZapato();
        break;
      case ANTEOJOS:
        tipoAAsignar = TipoPrenda.crearAnteojos();
        break;
      case PANTALON:
        tipoAAsignar = TipoPrenda.crearPantalon();
        break;
    }
    this.resultado.setTipoPrenda(tipoAAsignar);
  }

  public void buildMaterial(String nombreMaterial, Trama trama, String colorPrincipal, String colorSecundario) {
    Material material = new Material();
    material.setNombre(nombreMaterial);
    material.setTrama(trama);
    material.setColorPrincipal(colorPrincipal);
    material.setColorSecundario(colorSecundario);
    this.resultado.setMaterial(material);
  }

  public void buildReqClimaticos(Integer temperaturaMinF, Integer temperaturaMaxF) {
    ReqClimaticos reqClimaticos = new ReqClimaticos();
    reqClimaticos.setTemperaturaMinF(temperaturaMinF);
    reqClimaticos.setTemperaturaMaxF(temperaturaMaxF);
    this.resultado.setReqClimaticos(reqClimaticos);
  }

  public Prenda getResultado() throws PrendaIncompletaException, NoSuchFieldException, IllegalAccessException {
      this.resultado.validarAtributosCompletos();
      return this.resultado;
  }

  public void reset() {
    this.resultado = new Prenda();
  }

}
