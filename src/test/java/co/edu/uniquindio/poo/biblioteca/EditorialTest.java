package co.edu.uniquindio.poo.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class EditorialTest {
    private static final Logger LOG= Logger.getLogger(EditorialTest.class.getName());

@Test
public void datosCompletos(){
    LOG.info("inicio de prueba datos completos...");
    Editorial editorial = new Editorial("1HG22F", "Fundalectura", "3125678797");
    assertEquals("1HG22F",editorial.codigo());
    assertEquals("Fundalectura",editorial.nombre());
    assertEquals("3125678797",editorial.telefono());
    LOG.info("fin de prueba datos completos...");
}
@Test
public void datosNulos(){
    LOG.info("inicio de prueba datos nulos...");
    assertThrows(Throwable.class,()-> new Editorial(null, null, null));
    LOG.info("fin de prueba datos nulos...");
}
}
