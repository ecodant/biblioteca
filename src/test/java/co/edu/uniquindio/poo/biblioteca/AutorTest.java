package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AutorTest {
    private static final Logger LOG= Logger.getLogger(AutorTest.class.getName());

@Test
public void datosCompletos(){
    LOG.info("inicio de prueba datos completos...");
    Autor autor = new Autor("24CF76", "Gabriel", "Colombia");
    assertEquals("24CF76",autor.codigo());
    assertEquals("Gabriel",autor.nombre());
    assertEquals("Colombia",autor.nacionalidad());
    LOG.info("fin de la prueba datos completos...");
}
@Test 
public void datosNulos(){
    LOG.info("inicio de prueba datos nulos...");
    assertThrows(Throwable.class,()-> new Autor(null, null, null));
    LOG.info("fin de la prueba datos nulos...");
}
}
