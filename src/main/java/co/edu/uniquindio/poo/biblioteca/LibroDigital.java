package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;

public class LibroDigital extends Libro {
    private String direccionURL;

    public LibroDigital(String nombre, Autor autor, Editorial editorial, LocalDate fecha,String direccionURL){
        super(nombre, autor, editorial, fecha);
        ASSERTION.assertion(direccionURL != null && !direccionURL.isBlank(),"la direccion URL es requerida");
        this.direccionURL=direccionURL;
    }
    
    public String getDireccionURL(){
        return direccionURL;
    }
}
