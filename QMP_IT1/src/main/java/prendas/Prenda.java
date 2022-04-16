package prendas;

public class Prenda {

    private Categoria categoria;
    private TipoPrenda tipoPrenda;
    private String material;
    private String colorPrincipal;
    private String colorSecundario;


    // --- Setters --- //

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) throws Exception {

        if (this.esCompatible(this.categoria, tipoPrenda)) {
            this.tipoPrenda = tipoPrenda;
        }
        else {
            throw new Exception("El tipo ingresado no corresponde con la categoria de la prenda");
        }

        this.tipoPrenda = tipoPrenda;
    }

    private boolean esCompatible(Categoria categoria, TipoPrenda tipoPrenda) {
        DiccComp diccionario = DiccComp.getInstance();
        return diccionario.esValido(categoria, tipoPrenda);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    // --- Limitando las Prendas con atributos vacios --- //

    public Prenda(
            Categoria categoria,
            TipoPrenda tipoPrenda,
            String material,
            String colorPrincipal) throws Exception {

        this.setCategoria(categoria);
        this.setTipoPrenda(tipoPrenda);
        this.setMaterial(material);
        this.setColorPrincipal(colorPrincipal);
        this.setColorSecundario(null);
    }

    public Prenda(
            Categoria categoria,
            TipoPrenda tipoPrenda,
            String material,
            String colorPrincipal,
            String colorSecundario) throws Exception {

        this.setCategoria(categoria);
        this.setTipoPrenda(tipoPrenda);
        this.setMaterial(material);
        this.setColorPrincipal(colorPrincipal);
        this.setColorSecundario(colorSecundario);
    }

}