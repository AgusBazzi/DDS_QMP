package excepciones;

public class PrendaIncompletaException extends RuntimeException {

  private static String mensajeAtributoFaltante = "La prenda no es valida! Es obligatorio el campo: ";

  public PrendaIncompletaException() {
    super();
  }

  public PrendaIncompletaException(String atributoFaltante) {
    super(mensajeFinal(atributoFaltante));
  }

  private static String mensajeFinal(String atributoFaltante) {
    return mensajeAtributoFaltante + atributoFaltante;
  }

}
