import java.io.Serial;
import java.io.Serializable;

public class Disco implements Serializable, Comparable<Disco> {
    @Serial
    private static final long serialVersionUID = 3553341649517142560L;
    private String titulo;
    private String grupo;
    private float precio;
    private char disponibilidad;

    public Disco(String titulo, String grupo, float precio, char disponibilidad){
        this.titulo=titulo;
        this.grupo=grupo;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
    }

    public int compareTo(Disco disco) {
        int r=0;
        r=titulo.compareTo(disco.titulo);
        return r;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", grupo='" + grupo + '\'' +
                ", precio=" + precio +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}

