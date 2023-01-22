import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2Examen {
    public static void main(String[] args) throws IOException {
        File f1 = new File("fichTexto01.txt");
        File f2 = new File("fichTexto02.txt");
        File f3 = new File("fichero3.txt");


        FileReader fr1 = new FileReader(f1);
        FileReader fr2 = new FileReader(f2);

        BufferedReader fb1 = new BufferedReader(fr1);
        BufferedReader fb2 = new BufferedReader(fr2);
        String linea1 = "";
        String linea2 = "";
        String input = "";

        ArrayList<String> af1 = new ArrayList<>();
        ArrayList<String> af2 = new ArrayList<>();


        linea1 = fb1.readLine();
        while(linea1 != null){
            char[] lineacaracter = linea1.toCharArray();
            for(int cont = lineacaracter.length -1;cont >=0;cont--){
                input=input+lineacaracter[cont];
            }
            af1.add(input);
            input="";
            linea1 = fb1.readLine();
        }
        fb1.close();

        linea2 = fb2.readLine();
        while(linea2 != null){
            char[] lineacaracter2 = linea2.toCharArray();
            for(int cont = lineacaracter2.length -1;cont >=0;cont--){
                input=input+lineacaracter2[cont];
            }
            af2.add(input);
            input="";
            linea2 = fb2.readLine();
        }
        fb2.close();

        FileWriter fw = new FileWriter(f3);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator it = af1.iterator();
        Iterator it2 = af2.iterator();

        do{
            if(it.hasNext()){
                bw.write((String)it.next());
                bw.newLine();
            }
            bw.write((String)it2.next());
            bw.newLine();
        }while(it2.hasNext());

        bw.close();




    }
}
