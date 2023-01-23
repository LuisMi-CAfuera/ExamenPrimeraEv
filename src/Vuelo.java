import java.io.Serial;
import java.io.Serializable;

public class Vuelo implements Serializable, Comparable<Vuelo>{


    @Serial
    private static final long serialVersionUID = -7178433230551497822L;

    private String id = "";

    private int duracion = 0;


    public Vuelo(String id, int duracion) {
        this.id = id;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.duracion - o.duracion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id='" + id + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
