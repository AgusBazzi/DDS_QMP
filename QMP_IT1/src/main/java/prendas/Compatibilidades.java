package prendas;

import java.util.*;

public class Compatibilidades {

    private Map<Categoria, Set<TipoPrenda>> diccionario;

    // --- Singleton --- //
    private static Compatibilidades instance = null;

    private Compatibilidades(){};

    public static Compatibilidades getInstance()
    {
        if(instance == null)
        {
            instance = new Compatibilidades();

            instance.diccionario = new HashMap<>();

            instance.diccionario.put(Categoria.PARTE_INFERIOR, new HashSet<>(Arrays.asList(TipoPrenda.PANTALON)));
            instance.diccionario.put(Categoria.PARTE_SUPERIOR, new HashSet<>(Arrays.asList(TipoPrenda.CAMISA)));
            instance.diccionario.put(Categoria.CALZADO, new HashSet<>(Arrays.asList(TipoPrenda.ZAPATO)));
            instance.diccionario.put(Categoria.ACCESORIO, new HashSet<>(Arrays.asList(TipoPrenda.ANTEOJOS)));
        }
        return instance;
    }

    // --- Fin Singleton --- //

    public boolean esValido(Categoria categoria, TipoPrenda tipoPrenda) {
        return this.diccionario.get(categoria).contains(tipoPrenda);
    }
}
