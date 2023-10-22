package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class LibroDigitalTest {
    private static final Logger LOG= Logger.getLogger(LibroDigitalTest.class.getName());

@Test
public void datosCompletos(){
    LOG.info("inicio de prueba datos completos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    LibroDigital libroDigital = new LibroDigital("Cien años de soledad", autor, editorial, LocalDate.of(1967, 5, 15), "https://www.secst.cl/upfiles/documentos/19072016_1207am_578dc39115fe9.pdf");
    assertEquals("Cien años de soledad",libroDigital.getNombre());
    assertEquals(autor,libroDigital.getAutor());
    assertEquals(editorial,libroDigital.getEditorial());
    assertEquals(LocalDate.of(1967, 5, 15),libroDigital.getFecha());
    assertEquals("https://www.secst.cl/upfiles/documentos/19072016_1207am_578dc39115fe9.pdf",libroDigital.getUrl());
    LOG.info("fin de la prueba datos completos...");
}
@Test
public void datosNulos(){
    LOG.info("inicio de prueba datos nulos...");
    assertThrows(Throwable.class,()-> new LibroDigital(null, null, null, null, null));
    LOG.info("fin de la prueba datos nulos...");
}
@Test 
public void datosNegativos(){
    LOG.info("inicio de prueba datos negativos...");
    Editorial editorial= new Editorial("1HG22F", "Fundalectura","3125678797");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    assertThrows(Throwable.class,()-> new LibroDigital("Cien años de soledad", autor, editorial, LocalDate.of(-1967, -5, -15),"https://www.secst.cl/upfiles/documentos/19072016_1207am_578dc39115fe9.pdf"));
    LOG.info("fin de la prueba datos negativos...");
}
}
