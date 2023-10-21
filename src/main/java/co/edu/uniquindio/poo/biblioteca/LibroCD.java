package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;

public class LibroCD extends Libro{
    private Byte tamaño;
    private String formato;

    public LibroCD(String nombre, Autor autor, Editorial editorial, LocalDate fecha,Byte tamaño,String formato){
        super(nombre, autor, editorial, fecha);
        ASSERTION.assertion(tamaño >= 0,"El tamaño del libro no puede ser negativo");
        ASSERTION.assertion(formato != null && !formato.isBlank(),"El formato es requerido");
        this.tamaño = tamaño;
        this.formato = formato;
    }

    public Byte getTamaño() {
        return tamaño;
    }

    public String getFormato() {
        return formato;
    }
    
}
