package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public record Autor(String codigo, String nombre,String nacionalidad) {
    public Autor{
        ASSERTION.assertion(codigo != null && !codigo.isBlank(), "El ID es requerido");
        ASSERTION.assertion(nombre != null && !nombre.isBlank(),"El nombre del autor es requerido");
        ASSERTION.assertion(nacionalidad != null && !nacionalidad.isBlank(),"La nacionalidad del autor es requerida");
    }

}
