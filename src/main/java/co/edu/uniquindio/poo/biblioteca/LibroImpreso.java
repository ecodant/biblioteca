package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;

public class LibroImpreso extends Libro {
    private short cantidadEjemplares;

    public LibroImpreso(String nombre, Autor autor, Editorial editorial, LocalDate fecha, short cantidadEjemplares){
        super(nombre, autor, editorial, fecha);
        ASSERTION.assertion(cantidadEjemplares >= 0,"La cantidad de libros no puede ser negativa");
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public short getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    
}
