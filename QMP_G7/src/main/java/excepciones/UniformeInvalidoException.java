package excepciones;

public class UniformeInvalidoException extends RuntimeException {

  private static String mensajeFinal = "El uniforme no es valido";

  public UniformeInvalidoException() {
    super(mensajeFinal);
  }

}
