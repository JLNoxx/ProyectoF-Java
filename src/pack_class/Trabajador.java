package pack_class;
public class Trabajador {
  private int tra_codigo;
   private String tra_nombre;
   private String tra_apellido;
   private int tra_dni;
   private int tra_telefono;
   private boolean Tra_generoM;
   private boolean Tra_generoF;
   private String TraFechaNac;

    public Trabajador(String TraFechaNac) {
        this.TraFechaNac = TraFechaNac;
    }

    public Trabajador(boolean Tra_generoM, boolean Tra_generoF) {
        this.Tra_generoM = Tra_generoM;
        this.Tra_generoF = Tra_generoF;
    }

    public Trabajador() {
    }

    public Trabajador(int tra_codigo, String tra_nombre, String tra_apellido, int tra_dni, int tra_telefono) {
        this.tra_codigo = tra_codigo;
        this.tra_nombre = tra_nombre;
        this.tra_apellido = tra_apellido;
        this.tra_dni = tra_dni;
        this.tra_telefono = tra_telefono;
    }

    public int getTra_codigo() {
        return tra_codigo;
    }

    public void setTra_codigo(int tra_codigo) {
        this.tra_codigo = tra_codigo;
    }

    public String getTra_nombre() {
        return tra_nombre;
    }

    public void setTra_nombre(String tra_nombre) {
        this.tra_nombre = tra_nombre;
    }

    public String getTra_apellido() {
        return tra_apellido;
    }

    public void setTra_apellido(String tra_apellido) {
        this.tra_apellido = tra_apellido;
    }

    public int getTra_dni() {
        return tra_dni;
    }

    public void setTra_dni(int tra_dni) {
        this.tra_dni = tra_dni;
    }

    public int getTra_telefono() {
        return tra_telefono;
    }

    public void setTra_telefono(int tra_telefono) {
        this.tra_telefono = tra_telefono;
    }

    public boolean isTra_generoM() {
        return Tra_generoM;
    }

    public void setTra_generoM(boolean Tra_generoM) {
        this.Tra_generoM = Tra_generoM;
    }

    public boolean isTra_generoF() {
        return Tra_generoF;
    }

    public void setTra_generoF(boolean Tra_generoF) {
        this.Tra_generoF = Tra_generoF;
    }
   
   public String TrabajadorGenero(){
       if(Tra_generoM == true)
           return "Masculino";
       else if(Tra_generoF==true)
           return "Femenino";
       else return null;   }

    public String getTraFechaNac() {
        return TraFechaNac;
    }

    public void setTraFechaNac(String TraFechaNac) {
        this.TraFechaNac = TraFechaNac;
    }
	
}
