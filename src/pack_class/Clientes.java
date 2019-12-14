package pack_class;
public class Clientes {

    private String cli_direccion;
    private String cli_nombre;
    private String cli_apellido;
    private String cli_DNI;
    private int cli_telefono;
    private String cli_pais;
    private String cli_provincia;
    private String cli_distrito;

    public Clientes() {
    }

    public Clientes(String cli_direccion, String cli_nombre, String cli_apellido, String cli_DNI, int cli_telefono, String cli_pais, String cli_provincia, String cli_distrito) {
        this.cli_direccion = cli_direccion;
        this.cli_nombre = cli_nombre;
        this.cli_apellido = cli_apellido;
        this.cli_DNI = cli_DNI;
        this.cli_telefono = cli_telefono;
        this.cli_pais = cli_pais;
        this.cli_provincia = cli_provincia;
        this.cli_distrito = cli_distrito;
    }

    public String getCli_distrito() {
        return cli_distrito;
    }

    public void setCli_distrito(String cli_distrito) {
        this.cli_distrito = cli_distrito;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public String getCli_DNI() {
        return cli_DNI;
    }

    public void setCli_DNI(String cli_DNI) {
        this.cli_DNI = cli_DNI;
    }

    public int getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(int cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_pais() {
        return cli_pais;
    }

    public void setCli_pais(String cli_pais) {
        this.cli_pais = cli_pais;
    }

    public String getCli_provincia() {
        return cli_provincia;
    }

    public void setCli_provincia(String cli_provincia) {
        this.cli_provincia = cli_provincia;
    }
    
    
    
    
}
