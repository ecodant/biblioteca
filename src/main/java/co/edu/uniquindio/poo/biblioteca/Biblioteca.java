package co.edu.uniquindio.poo.biblioteca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        Predicate<Libro> condicion = l -> l.getNombre().equals(libro.getNombre()) && l.getClass() == libro.getClass();

        boolean condicionMet = libros.stream().anyMatch(condicion);
    
        ASSERTION.assertion(!condicionMet, "El libro que intenta crear ya existe.");
    }
    
    public Collection<Libro> buscarLibrosPorAutor(Autor autor){

        Predicate<Libro> nombreIgual= n->n.getAutor().nombre().equalsIgnoreCase(autor.nombre());
        Predicate<Libro> nacionalidadIgual= n->n.getAutor().nacionalidad().equals(autor.nacionalidad());
        
        return libros.stream().filter(nombreIgual.and(nacionalidadIgual)).collect(Collectors.toList());
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre){
        Predicate<Libro> condicion= l-> l.getNombre().equals(nombre);
        return libros.stream().filter(condicion).findAny();
    }

    //Libros digitales que tengan version impresa.
    public Optional<LibroImpreso> buscarLibrosDigitalesConVersionImpresa(LibroDigital libroBuscado) {
        Predicate<Libro> condicion = libro -> libro instanceof LibroImpreso &&
            libro.getNombre().equalsIgnoreCase(libroBuscado.getNombre()) && 
            libro.getAutor().equals(libroBuscado.getAutor()) &&
            libro.getEditorial().equals(libroBuscado.getEditorial()) &&
            libro.getFecha().equals(libroBuscado.getFecha());
        Optional<Libro> libroEncontrado = libros.stream().filter(condicion).findAny();
        if (libroEncontrado.isPresent() && libroEncontrado.get() instanceof LibroImpreso) {
            return Optional.of((LibroImpreso) libroEncontrado.get());
        } else {
            return Optional.empty();
        }
    }
    //Libros cd por nombre y formato.
    public Optional<Libro> buscarLibrosCDPorNombreYFormato(String nombre, String formato){
        Predicate<Libro> condicion= libro -> libro instanceof LibroCD &&
        libro.getNombre().equalsIgnoreCase(nombre) && libro.getFormato().equals(formato);

        return libros.stream()
                .filter(condicion)
                .findAny();
    }
    //Con el nombre de un libro indicar cuantos tipos tiene.
    public short contarTiposDeLibro(String nombre){
        long cuenta = libros.stream().filter(libro -> libro.getNombre().equalsIgnoreCase(nombre)).count();
        return (short) cuenta;
    }
}
