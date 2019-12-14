package pack_class;

public class Cotizacion {
private String cot_material;
private int cot_codigo;
private int cot_cantidad;
private double cot_precio;

    public Cotizacion(String cot_material, int cot_codigo, int cot_cantidad, double cot_precio) {
        this.cot_material = cot_material;
        this.cot_codigo = cot_codigo;
        this.cot_cantidad = cot_cantidad;
        this.cot_precio = cot_precio;
    }

    public Cotizacion() {
    }

    public String getCot_material() {
        return cot_material;
    }

    public void setCot_material(String cot_material) {
        this.cot_material = cot_material;
    }

    public int getCot_codigo() {
        return cot_codigo;
    }

    public void setCot_codigo(int cot_codigo) {
        this.cot_codigo = cot_codigo;
    }

    public int getCot_cantidad() {
        return cot_cantidad;
    }

    public void setCot_cantidad(int cot_cantidad) {
        this.cot_cantidad = cot_cantidad;
    }

    public double getCot_precio() {
        return cot_precio;
    }

    public void setCot_precio(double cot_precio) {
        this.cot_precio = cot_precio;
    }

   public double PrecioxCatidad(){
       return cot_precio*cot_cantidad;
   }
    
    
    
	
}
