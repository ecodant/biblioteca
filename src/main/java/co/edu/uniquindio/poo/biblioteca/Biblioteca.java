package co.edu.uniquindio.poo.biblioteca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Biblioteca {
    private String nombre;
    private Collection <Libro> libros;

    public Biblioteca(String nombre){
        ASSERTION.assertion(nombre != null && !nombre.isBlank(),"EL nombre de la biblioteca es requerido");

        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }
    public void setNombre(String nombre){
        ASSERTION.assertion(nombre != null, "El nombre is invalido");
        this.nombre = nombre;
    }

    public void crearLibro(Libro libro){
        verificarLibroExistente(libro);
        libros.add(libro);
    }

    private void verificarLibroExistente(Libro libro){
        Predicate<Libro> condicion = b -> b.getNombre().equals(b.getNombre()) && b.getClass() == b.getClass();

        boolean condicionMet = libros.stream().anyMatch(condicion);
    
        ASSERTION.assertion(!condicionMet, "El libro que intenta crear ya existe.");
    }
    
    public Optional<Libro> buscarLibrosPorAutor(Autor autor){
        Predicate<Libro> nombreIgual= n->n.getAutor().getNombre().equals(autor.getNombre());
        Predicate<Libro> nacionalidadIgual= n->n.getAutor().getNacionalidad().equals(autor.getNacionalidad());
        return libros.stream().filter(nombreIgual.and(nacionalidadIgual)).findAny();
    }


    public Optional<Libro> buscarLibroPorNombre(String nombre){
        Predicate<Libro>condicion= l->l.getNombre().equals(nombre);
        return libros.stream().filter(condicion).findAny();
    }

    //Libros digitales que tengan version impresa.
    public Optional<LibroDigital> buscarLibrosDigitalesConVersionImpresa(LibroDigital libroBuscado){
        Predicate<Libro> condicion = l -> l instanceof LibroDigital &&
        l.getNombre().equals(libroBuscado.getNombre()) &&
        l.getEditorial().equals(libroBuscado.getEditorial()) &&
        l.getFecha() == libroBuscado.getFecha() &&
        l.getAutor().equals(libroBuscado.getAutor());

        Optional<LibroDigital> libroImpresoComparar = libros.stream()
        .filter(libro -> libro instanceof LibroDigital)
        .map(libro -> (LibroDigital) libro)
        .filter(libroImpreso -> 
            libroImpreso.getNombre().equals(libroBuscado.getNombre()) &&
            libroImpreso.getEditorial().equals(libroBuscado.getEditorial()) &&
            libroImpreso.getFecha() == libroBuscado.getFecha() &&
            libroImpreso.getAutor().equals(libroBuscado.getAutor()))
        .findAny();

        if (libroImpresoComparar.isPresent()){
            return libros.stream()
                    .filter(condicion)
                    .map(libro -> (LibroDigital) libro)
                    .findAny();
        } else return Optional.empty();
    }
    //Libros cd por nombre y formato.
    public Optional<Libro> buscarLibrosCDPorNombreYFormato(String nombre, String formato){
        Predicate<Libro> condicion= libro -> libro instanceof LibroCD &&
        libro.getNombre().equals(nombre) && libro.getFormato().equals(formato);
        return libros.stream().filter(condicion).findAny();
    }
    //Con el nombre de un libro indicar cuantos tipos tiene.
    public short contarTiposDeLibro(String nombre){
        long cuenta = libros.stream().filter(libro -> libro.getNombre().equals(nombre)).count();
        return (short)cuenta;
    }
}
