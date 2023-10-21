package co.edu.uniquindio.poo.biblioteca;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;

public class LibroDigital extends Libro {
    private String url;

    public LibroDigital(String nombre, Autor autor, Editorial editorial, LocalDate fecha, String url) {
        super(nombre, autor, editorial, fecha);
        ASSERTION.assertion(url != null && !url.isBlank(),"La URL es requerida");
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
