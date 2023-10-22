package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class LibroCdTest {
    private static final Logger LOG= Logger.getLogger(LibroCdTest.class.getName());
    
@Test
public void datosCompletos(){
    LOG.info("inicio de prueba datos completos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    LibroCD libroCD = new LibroCD("Cien años de soledad", (Autor)autor, editorial, LocalDate.of(1967, 5, 15), (byte)10, "CD-ROM");
    assertEquals("Cien años de soledad",libroCD.getNombre());
    assertEquals(autor,libroCD.getAutor());
    assertEquals(editorial,libroCD.getEditorial());
    assertEquals(LocalDate.of(1967, 5, 15),libroCD.getFecha());
    assertEquals((byte)10,libroCD.getTamaño());
    assertEquals("CD-ROM",libroCD.getFormato());
    LOG.info("fin de la prueba datos completos...");
}
@Test
public void datosNulos(){
    LOG.info("inicio de la prueba datos nulos...");
    assertThrows(Throwable.class,()-> new LibroCD(null, null, null, null, 0, null));
    LOG.info("fin de la prueba datos nulos...");
}
@Test void datosNegativos(){
    LOG.info("inicio de la prueba datos negativos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    assertThrows(Throwable.class,()-> new LibroCD("Cien años de soledad", autor, editorial, LocalDate.of(-1967, -5, -15), (float)-10, "CD-ROM"));
    LOG.info("fin de la prueba datos negativos...");
}
}
