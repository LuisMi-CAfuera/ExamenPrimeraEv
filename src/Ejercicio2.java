import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        File fO=new File("fichTexto01.txt");
        File fO2=new File("fichTexto02.txt");
        File fN = new File("ficheroTexto03.txt");

        FileReader fR1= new FileReader(fO);
        FileReader fR2 = new FileReader(fO2);

        BufferedReader bR1 = new BufferedReader(fR1);
        BufferedReader bR2 = new BufferedReader(fR2);
        String linea="";
        String linea2="";
        String poner="";

        ArrayList<String> aFich1 = new ArrayList<>();
        ArrayList<String> aFich2= new ArrayList<>();

        linea=bR1.readLine();
        while (linea!=null){
            char[] lineacaracter= linea.toCharArray();
            for (int cont=lineacaracter.length-1; cont>=0; cont--){
                poner=poner+lineacaracter[cont];
            }
            aFich1.add(poner);
            poner="";
            linea=bR1.readLine();
        }
        bR1.close();

        linea2=bR2.readLine();
        while (linea2!=null){
            char[] lineacaracter2= linea2.toCharArray();
            for (int cont=lineacaracter2.length-1; cont>=0; cont--){
                poner=poner+lineacaracter2[cont];
            }
            aFich2.add(poner);
            poner="";
            linea2=bR2.readLine();
        }
        bR2.close();

        FileWriter fW = new FileWriter(fN);
        BufferedWriter bW = new BufferedWriter(fW);
        Iterator it = aFich1.iterator();
        Iterator it2 = aFich2.iterator();

        do {
            if (it.hasNext()){
                bW.write((String) it.next());
                bW.newLine();
            }
            bW.write((String) it2.next());
            bW.newLine();
        }while(it2.hasNext());
        
        bW.close();
    }
}

