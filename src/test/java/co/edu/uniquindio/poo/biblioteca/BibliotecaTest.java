package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
    private static final Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());

    @Test
    public void agregarLibroBiblioteca() {
        LOG.info("Ejecutando prueba...");

        Collection<Libro> librosAComparar = new ArrayList<>((int) 200);

        Autor autor = new Autor("122444", "Gabriel", "colombiano");
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroDigital = new LibroDigital("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), "https://es.wikipedia.org/wiki/Cien_a%C3%B1os_de_soledad");
        Libro libroImpreso = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 20000);

        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");
        biblioteca.crearLibro(libroDigital);
        biblioteca.crearLibro(libroImpreso);

        librosAComparar.add(libroDigital);
        librosAComparar.add(libroImpreso);

        List<Libro> listaLibrosBiblioteca = new ArrayList<>(biblioteca.getLibros());

        assertEquals(librosAComparar, listaLibrosBiblioteca);
    }

    @Test
    public void libroConMismoNombreTest() {
        Autor autor = new Autor("122444", "Gabriel", "colombiano");
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroImpreso = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 20000);
        Libro libroImpreso2 = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 20000);

        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");
        biblioteca.crearLibro(libroImpreso);
        assertThrows(Throwable.class, () -> biblioteca.crearLibro(libroImpreso2));
    }

    @Test
    public void librosDigitalesConVersionImpresaTest() {
        LOG.info("Ejecutando prueba...");

        Autor autor = new Autor("122444", "Gabriel", "colombiano");
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroDigital = new LibroDigital("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), "https://es.wikipedia.org/wiki/Cien_a%C3%B1os_de_soledad");
        Libro libroImpreso = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 2000);

        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");
        biblioteca.crearLibro(libroDigital);
        biblioteca.crearLibro(libroImpreso);
        
        assertEquals(libroDigital, biblioteca.buscarLibrosDigitalesConVersionImpresa((LibroDigital) libroDigital).orElse(null));

    }
}
