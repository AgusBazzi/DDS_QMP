package excepciones;

public class PrendaIncompatibleException extends RuntimeException {

  private static String mensajeFinal = "La prenda no es valida! El tipo y categoria no son compatibles.";

  public PrendaIncompatibleException() {
    super(mensajeFinal);
  }

}
