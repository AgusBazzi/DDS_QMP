package excepciones;

public class PrendaDeUniformeIncorrectaException extends RuntimeException {

  private static String mensajeCategoriaErronea = "Se esperaba una prenda de categoria: ";

  public PrendaDeUniformeIncorrectaException() {
    super();
  }

  public PrendaDeUniformeIncorrectaException(String categoriaEsperada) {
    super(mensajeFinal(categoriaEsperada));
  }

  private static String mensajeFinal(String categoriaEsperada) {
    return mensajeCategoriaErronea + categoriaEsperada;
  }

}
