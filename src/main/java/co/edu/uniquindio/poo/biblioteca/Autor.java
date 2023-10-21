package co.edu.uniquindio.poo.biblioteca;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
public class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre,String nacionalidad){
        ASSERTION.assertion(nombre != null && !nombre.isBlank(),"El nombre del autor es requerido");
        ASSERTION.assertion(nacionalidad != null && !nacionalidad.isBlank(),"La nacionalidad del autor es requerida");
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
}
