package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
public record Editorial (String codigo, String nombre,String telefono) {
    public Editorial{
        ASSERTION.assertion(codigo != null && !codigo.isBlank(), "El ID es requerido");
        ASSERTION.assertion(nombre != null && !nombre.isBlank(),"El nombre de la editorial es requerido");
        ASSERTION.assertion(telefono != null && !telefono.isBlank(),"El telefono de la editorial es requerido");
        
      }
}
