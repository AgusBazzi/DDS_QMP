package excepciones;

public class PrendaInexistenteException extends RuntimeException {

	private static String mensajePrendaNoExistente = "No existe en el guardarropa una prenda de categoria: ";

	public PrendaInexistenteException() {
	    super();
	  }

	public PrendaInexistenteException(String categoriaInexistente) {
	    super(mensajeFinal(categoriaInexistente));
	  }

	private static String mensajeFinal(String categoriaInexistente) {
		return mensajePrendaNoExistente + categoriaInexistente;
	}
}
