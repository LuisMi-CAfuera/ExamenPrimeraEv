import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Eejrcicio1Examen {

    public static void main(String[] args) throws IOException {
        ArrayList<Disco> aD = new ArrayList<>();

        aD.add(new Disco("Titulo2","Artista1",(float)10,'S'));
        aD.add(new Disco("Titulo1","Artista2",(float)23,'N'));
        aD.add(new Disco("Titulo4","Artista3",(float)20,'S'));
        aD.add(new Disco("Titulo3","Artista4",(float)7,'N'));


        almacenar("ficheroEj1.bin",aD,false);

        almacenar("ficheroEj1.bin",aD,true);

        recuperar("ficheroEj1.bin");

    }


    public static void almacenar(String fichero,ArrayList<Disco> discos,boolean orden) throws IOException {
        File f = new File(fichero);

        ObjectOutputStream  fO= null;

        if(!f.exists()){
            fO = new ObjectOutputStream(new FileOutputStream(f,false));
        }else {
            fO = new ObjectOutput2(new FileOutputStream(f,true));
        }

        if(orden){
            Collections.sort(discos);
        }

        for(Disco disco : discos){
            fO.writeObject(disco);
        }
        fO.close();

    }





    public static void recuperar(String fichero) throws IOException {
        File f = new File(fichero);

        ObjectInputStream fO = new ObjectInputStream(new FileInputStream(f));

        try{
            do{
                System.out.println(fO.readObject());
            }while (true);
        }catch (EOFException e){
            System.out.println("Fin del fichero");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        fO.close();

    }
}
