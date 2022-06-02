package dominio.prendas;

public class TipoPrenda {
    private TipoDePrendaEnum tipoDePrenda;
    private Categoria categoria;

    private TipoPrenda(TipoDePrendaEnum tipoDePrenda, Categoria unaCategoria) {
        this.tipoDePrenda = tipoDePrenda;
        this.categoria = unaCategoria;
    }

    public static TipoPrenda crearRemera() {
        return new TipoPrenda(TipoDePrendaEnum.REMERA, Categoria.PARTE_SUPERIOR);
    }

    public static TipoPrenda crearPantalon() {
        return new TipoPrenda(TipoDePrendaEnum.PANTALON, Categoria.PARTE_INFERIOR);
    }

    public static TipoPrenda crearZapato() {
        return new TipoPrenda(TipoDePrendaEnum.ZAPATO, Categoria.CALZADO);
    }

    public static TipoPrenda crearAnteojos() {
        return new TipoPrenda(TipoDePrendaEnum.ANTEOJOS, Categoria.ACCESORIO);
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Boolean tieneCategoria(Categoria unaCategoria) {
        return this.categoria.equals(unaCategoria);
    }

    public TipoDePrendaEnum getTipoDePrenda() {
        return this.tipoDePrenda;
    }
}

