package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;


public abstract class Libro {
    private String nombre;
    private Autor autor;
    private Editorial editorial;
    private LocalDate fecha;
    
    public Libro(String nombre, Autor autor, Editorial editorial, LocalDate fecha){
        ASSERTION.assertion(nombre != null && !nombre.isBlank(),"El nombre del libro es requerido");
        ASSERTION.assertion(fecha != null,"La fecha de publicacion no puede ser nula");

        this.nombre = nombre;
        this.fecha = fecha;
    }
    public String getNombre() {
        return nombre;
    }
    public Autor getAutor() {
        return autor;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public Object getFecha() {
        return fecha;
    }

    public Object getFormato() {
        return null;
    }
}

