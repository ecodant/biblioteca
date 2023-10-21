package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
    private static final Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());

    @Test
    public void agregarLibroBiblioteca() {
        LOG.info("Ejecutando prueba...");

        Autor autor = new Autor("122444", "Gabriel", "colombiano");
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroDigital = new LibroDigital("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), "https://es.wikipedia.org/wiki/Cien_a%C3%B1os_de_soledad");
        Libro libroImpreso = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 20000);

        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");
        biblioteca.crearLibro(libroDigital);
        biblioteca.crearLibro(libroImpreso);

        assertTrue(biblioteca.getLibros().contains(libroDigital));
        assertTrue(biblioteca.getLibros().contains(libroImpreso));
        assertEquals(2, biblioteca.getLibros().size());
        
        LOG.info("Prueba Finalizada");
    }
    @Test
    public void buscarLibroPorAutorTest(){

        LOG.info("Ejecutando prueba...");
        Autor autor1 = new Autor("122444", "Gabriel Garcia Marquez", "colombiano");
        Autor autor2 = new Autor("1234266", "Miguel De Cervantes", "spanish");
        Autor autor3 = new Autor("3434221", "Nicolas Maquiavelo", "italian");
        
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroDigital1 = new LibroDigital("El Quijote", autor2, editorial, LocalDate.of(1605, 01, 1), "https://es.wikipedia.org/wiki/Don_Quijote_de_la_Mancha");
        Libro libroDigital2 = new LibroDigital("El Principe", autor3, editorial, LocalDate.of(1872, 05, 1), "https://es.wikipedia.org/wiki/El_pr%C3%ADncipe");
        Libro libroDigital3 = new LibroDigital("Cien años de Soledad", autor1, editorial, LocalDate.of(1967, 05, 1), "https://es.wikipedia.org/wiki/Cien_a%C3%B1os_de_soledad");
        Libro libroImpreso1 = new LibroImpreso("Cien años de Soledad", autor1, editorial, LocalDate.of(1967, 05, 1), (short) 20000);
        Libro libroImpreso2 = new LibroImpreso("12 Cuentos Peregrinos", autor1, editorial, LocalDate.of(1992, 01, 1), (short) 20000);
        Libro libroImpreso3 = new LibroImpreso("La Hojarasca", autor1, editorial, LocalDate.of(1955, 01, 1), (short) 20000);

        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");

        //Añadiendo Varios libros a la libreria
        biblioteca.crearLibro(libroDigital1);
        biblioteca.crearLibro(libroDigital2);
        biblioteca.crearLibro(libroDigital3);

        biblioteca.crearLibro(libroImpreso2);
        biblioteca.crearLibro(libroImpreso3);
        biblioteca.crearLibro(libroImpreso1);

        assertTrue(biblioteca.buscarLibrosPorAutor(autor1).contains(libroDigital3));
        assertTrue(biblioteca.buscarLibrosPorAutor(autor1).contains(libroImpreso1));
        assertTrue(biblioteca.buscarLibrosPorAutor(autor1).contains(libroImpreso2));
        assertTrue(biblioteca.buscarLibrosPorAutor(autor1).contains(libroImpreso3));
        assertEquals(4, biblioteca.buscarLibrosPorAutor(autor1).size());

        LOG.info("Prueba Finalizada");
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
        
        assertEquals(libroImpreso, biblioteca.buscarLibrosDigitalesConVersionImpresa((LibroDigital) libroDigital).orElse(null));

        LOG.info("Prueba Finalizada");
    }
    @Test
    public void buscarLibroCD(){
        LOG.info("Ejecutando prueba...");

        Autor autor = new Autor("122444", "Gabriel Garcia Marquez", "colombiano");
        
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroAEncontrar = new LibroCD("El Quijote", autor, editorial, LocalDate.of(1605, 01, 1), (float)12832.32, "WAV");
        Biblioteca biblioteca = new Biblioteca("El paraíso de la Lectura");
        biblioteca.crearLibro(libroAEncontrar);

        assertEquals(libroAEncontrar,biblioteca.buscarLibrosCDPorNombreYFormato("El Quijote", "WAV").orElse(null));
        LOG.info("Prueba Finalizada");
    }
    @Test
    public void APartirDelNombrecuantosTiposHayTest(){
        LOG.info("Ejecutando prueba...");

        Autor autor = new Autor("122444", "Gabriel Garcia Marquez", "colombiano");
        Editorial editorial = new Editorial("1234567", "El Buho", "93-728267");

        Libro libroCD = new LibroCD("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (float)192.22, "WAV");
        Libro libroDigital = new LibroDigital("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), "https://es.wikipedia.org/wiki/Cien_a%C3%B1os_de_soledad");
        Libro libroImpreso = new LibroImpreso("Cien años de Soledad", autor, editorial, LocalDate.of(1967, 05, 1), (short) 20000);

        Biblioteca biblioteca = new Biblioteca("El renacer del Libro");
        biblioteca.crearLibro(libroCD);
        biblioteca.crearLibro(libroDigital);
        biblioteca.crearLibro(libroImpreso);

        assertEquals((short) 3 ,biblioteca.contarTiposDeLibro("Cien AÑOS de Soledad"));
        LOG.info("Prueba Finalizada");
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

        LOG.info("Prueba Finalizada");
    }

}
