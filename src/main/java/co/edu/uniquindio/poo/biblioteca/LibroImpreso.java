package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;

public class LibroImpreso extends Libro {
    private Byte cantidadEjemplares;

    public LibroImpreso(String nombre, Autor autor, Editorial editorial, LocalDate fecha,Byte cantidadEjemplares){
        super(nombre, autor, editorial, fecha);
        ASSERTION.assertion(cantidadEjemplares >= 0,"La cantidad de libros no puede ser negativa");
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public Byte getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    
}
