import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1{
    public static void main(String[] args) throws IOException {
        ArrayList<Disco> discos= new ArrayList<>();

        discos.add(new Disco("Titulo2", "Grupo1", (float) 200.56, 'S'));
        discos.add(new Disco("Titulo3", "Grupo2", (float)300.2, 'N'));
        discos.add(new Disco("Titulo1", "Grupo3", (float)400.90, 'S'));
        discos.add(new Disco("Ave Fenix", "Grupo4", (float)500.34, 'N'));

        almacenar("ficheroEj1.bin", discos, false);
        almacenar("ficheroEj1.bin", discos, true);
        recuperar("ficheroEj1.bin");

    }

    public static void almacenar(String fichero, ArrayList<Disco> discos, boolean orden) throws IOException {
        File f= new File(fichero);

        ObjectOutputStream fO=null;

        if (f.exists()){
            fO =new ObjectOutput2(new FileOutputStream(f, true));
        }else {
            fO =new ObjectOutputStream(new FileOutputStream(f, false));
        }
        
        if (orden){
            Collections.sort(discos);
        }
        
        for (Disco disco :discos){
            fO.writeObject(disco);
        }

        fO.close();
    }

    public static void recuperar(String fichero) throws IOException {
        File f = new File(fichero);
        ObjectInputStream fI = new ObjectInputStream(new FileInputStream(f));

        try {
            do {
                System.out.println(fI.readObject());
            }while(true);
        }catch(EOFException e) {
            System.out.println("Final de fichero");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        fI.close();

    }
}
