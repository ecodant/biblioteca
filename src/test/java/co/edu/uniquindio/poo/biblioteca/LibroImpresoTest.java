package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class LibroImpresoTest {
    private static final Logger LOG= Logger.getLogger(LibroImpresoTest.class.getName());

@Test
public void datosCompletos(){
    LOG.info("inicio de prueba datos completos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    LibroImpreso libroImpreso = new LibroImpreso("Cien años de soledad", autor, editorial, LocalDate.of(1967, 5, 15),(short)5);
    assertEquals("Cien años de soledad",libroImpreso.getNombre());
    assertEquals(autor,libroImpreso.getAutor());
    assertEquals(editorial,libroImpreso.getEditorial());
    assertEquals(LocalDate.of(1967, 5, 15),libroImpreso.getFecha());
    assertEquals((short)5,libroImpreso.getCantidadEjemplares());
    LOG.info("fin de prueba datos completos...");
}
@Test
public void datosNulos(){
    LOG.info("inicio de prueba datos nulos...");
    assertThrows(Throwable.class,()->new LibroImpreso(null, null, null, null, (short)0));
    LOG.info("fin de prueba datos nulos...");
}
@Test
public void datosNegativos(){
    LOG.info("inicio de prueba datos negativos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    assertThrows(Throwable.class,()-> new LibroImpreso("Cien años de soledad", autor, editorial, LocalDate.of(-1967, -5, -15), (short)5));
    LOG.info("fin de prueba datos negativos...");
}
}
