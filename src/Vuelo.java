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

    @Override
    public int compareTo(Vuelo o) {
        int r = 0;

        r=id.compareTo(o.id);

        return r;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id='" + id + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
