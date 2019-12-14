package pack_class;

public class Repuestos {
    
   private String nombre;
   private String codigo;
   private int stock;
   private double precio;

    public Repuestos() {
    }

    public Repuestos(String nombre, String codigo, int stock, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int sotck) {
        this.stock = sotck;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
