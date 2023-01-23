import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Vuelo2 {

    public static void main(String[] args) throws IOException {
        Vuelo v1 = new Vuelo("ABC234",234);
        Vuelo v2 = new Vuelo("def567",234);

        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        ArrayList<Vuelo> vuelos2 = new ArrayList<Vuelo>();
        File f = new File("vuelo.bin");
        Vuelo aux = new Vuelo("",0);

        ObjectInputStream fI = new ObjectInputStream(new FileInputStream(f));

        vuelos.add(v1);
        vuelos.add(v2);

        almacenar("ficheroEj2.bin",vuelos,false);

        almacenar("ficheroEj2.bin",vuelos,true);

        recuperar("ficheroEj2.bin");



        try{
            do{
                aux = (Vuelo) fI.readObject();

                if(aux.getDuracion() >= 120 ){
                    vuelos2.add(aux);
                }

            }while (true);
        }catch (EOFException e){
            System.out.println("Fin de Fichero");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        fI.close();

        Collections.sort(vuelos2);

        ObjectOutputStream fO= null;

        if(!f.exists()){
            fO = new ObjectOutputStream(new FileOutputStream(f,false));
        }else {
            fO = new ObjectOutput2(new FileOutputStream(f,true));
        }


        for(Vuelo vuelo : vuelos2){
            fO.writeObject(vuelo.toString());
        }
        fO.close();









    }


    public static void almacenar(String fichero,ArrayList<Vuelo> vuelos,boolean orden) throws IOException {
        File f = new File(fichero);

        ObjectOutputStream fO= null;

        if(!f.exists()){
            fO = new ObjectOutputStream(new FileOutputStream(f,false));
        }else {
            fO = new ObjectOutput2(new FileOutputStream(f,true));
        }

        if(orden){
            Collections.sort(vuelos);
        }

        for(Vuelo vuelo : vuelos){
            fO.writeObject(vuelo.toString());
        }
        fO.close();

    }

    public static void recuperar(String fichero) throws IOException {
        File f = new File(fichero);

        ObjectInputStream fO = new ObjectInputStream(new FileInputStream(f));

        try{
            do{
                System.out.println(fO.readObject().toString());
            }while (true);
        }catch (EOFException e){
            System.out.println("Fin de fichero");
        }catch (Exception e){
            System.out.println("Error");
        }

        fO.close();
    }

}
