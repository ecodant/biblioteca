package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
public class Editorial {
    private String nombre;
    private String telefono;

public Editorial(String nombre,String telefono){
    ASSERTION.assertion(nombre != null && !nombre.isBlank(),"El nombre de la editorial es requerido");
    ASSERTION.assertion(telefono != null && !telefono.isBlank(),"El telefono de la editorial es requerido");
    this.nombre = nombre;
    this.telefono = telefono;
}

public String getNombre() {
    return nombre;
}

public String getTelefono() {
    return telefono;
}

}
