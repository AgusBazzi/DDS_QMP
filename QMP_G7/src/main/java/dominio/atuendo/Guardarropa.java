package dominio.atuendo;

import java.util.ArrayList;
import java.util.List;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import excepciones.PrendaInexistenteException;
import dominio.prendas.Categoria;
import dominio.prendas.Prenda;
import servicios.Clima;

public class Guardarropa {

	// esta bien el package?

	private List<Prenda> prendas = new ArrayList<>();

	public Guardarropa() {
	}
	// private List<Atuendo> atuendosPersonalizados; no estoy seguro si esto
	// realmente importa //en el d de clases tiene lista de prendas

	public Atuendo crearSugerencia(Clima unClima) { // no puse lo de clima porque entiendo no lo implementamos
		Atuendo unaSugerencia = new Atuendo();
		agregarPrendaSugerida(unaSugerencia, Categoria.PARTE_SUPERIOR, unClima);
		agregarPrendaSugerida(unaSugerencia, Categoria.PARTE_INFERIOR, unClima);
		agregarPrendaSugerida(unaSugerencia, Categoria.CALZADO, unClima);
		return unaSugerencia;
	} //testear

	public Atuendo crearSugerenciaConAccesorio(Clima unClima) {
		Atuendo unaSugerencia;
		unaSugerencia = crearSugerencia(unClima);
		agregarPrendaSugerida(unaSugerencia, Categoria.ACCESORIO, unClima);
		return unaSugerencia;
	} //testear

	public List<Atuendo> variasSugerencias(int cantidadSugerencias, Clima unClima) {
		List<Atuendo> listaSugerencias = new ArrayList<>();
		for (int i = 0; i < cantidadSugerencias; i++) {
			Atuendo unaSugerencia;
			if (Math.random() == 0) {
				unaSugerencia = crearSugerencia(unClima);
			} else {
				unaSugerencia = crearSugerenciaConAccesorio(unClima);
			}
			listaSugerencias.add(unaSugerencia);
		}

		return listaSugerencias;
	} // test, ver como hacer que no repita sugerencias

	private void agregarPrendaSugerida(Atuendo atuendoSugerido,
																		 Categoria unaCategoria,
																		 Clima unClima) throws PrendaInexistenteException {
		Prenda unaPrendaSugerida;
		unaPrendaSugerida = prendas
				.stream()
				.filter(prenda -> prenda.esAptaParaSerSugerible(unaCategoria, unClima))
				.findAny()
				.get();

		if (unaPrendaSugerida == null) {
			throw new PrendaInexistenteException(unaCategoria.toString() );
		} else {
			atuendoSugerido.agregarPrenda(unaPrendaSugerida);
		}
	}

	public void addPrenda(Prenda unaPrenda) {
		this.prendas.add(unaPrenda);
	}

	public List<Prenda> getPrendas() {
		return this.prendas;
	}
}
