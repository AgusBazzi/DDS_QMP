package atuendo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

import excepciones.PrendaInexistenteException;
import prendas.Categoria;
import prendas.Prenda;

public class Guardarropa {

	// esta bien el package?

	private List<Prenda> prendas = new ArrayList<>();

	public Guardarropa() {
	}
	// private List<Atuendo> atuendosPersonalizados; no estoy seguro si esto
	// realmente importa //en el d de clases tiene lista de prendas

	public Atuendo crearSugerencia() { // no puse lo de clima porque entiendo no lo implementamos
		Atuendo unaSugerencia = new Atuendo();
		agregarPrendaSugerida(unaSugerencia, Categoria.PARTE_SUPERIOR);
		agregarPrendaSugerida(unaSugerencia, Categoria.PARTE_INFERIOR);
		agregarPrendaSugerida(unaSugerencia, Categoria.CALZADO);
		return unaSugerencia;
	} //testear

	public Atuendo crearSugerenciaConAccesorio() {
		Atuendo unaSugerencia;
		unaSugerencia = crearSugerencia();
		agregarPrendaSugerida(unaSugerencia, Categoria.ACCESORIO);
		unaSugerencia.serUsado();
		return unaSugerencia;
	} //testear

	public List<Atuendo> variasSugerencias(Integer cantidadSugerencias) {
		List<Atuendo> listaSugerencias = new ArrayList<>();
		for (int i = 0; i < cantidadSugerencias; i++) {
			Atuendo unaSugerencia;
			if (Math.random() == 0) {
				unaSugerencia = crearSugerencia();
			} else {
				unaSugerencia = crearSugerenciaConAccesorio();
			}
			listaSugerencias.add(unaSugerencia);
		}

		return listaSugerencias;
	} // test, ver como hacer que no repita sugerencias

	private void agregarPrendaSugerida(Atuendo atuendoSugerido, Categoria unaCategoria) throws PrendaInexistenteException {
		Prenda unaPrendaSugerida;
		unaPrendaSugerida = prendas
				.stream()
				.filter(prenda -> prenda.puedeSerSugerida(unaCategoria))
				.findAny()
				.get();

		if (unaPrendaSugerida == null) {
			throw new PrendaInexistenteException(unaCategoria.toString());
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
