import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Codificar {
    public static void main(String[] args) throws IOException {
        File fO=new File("C:\\Users\\AlumnoM\\Documents\\DAM2\\DAM2-ACC\\ExamenFicheros\\src\\quijote.txt");
        File fN=new File("C:\\Users\\AlumnoM\\Documents\\DAM2\\DAM2-ACC\\ExamenFicheros\\src\\quijote_codificado.txt");

        FileReader fR=new FileReader(fO);
        FileWriter fW=new FileWriter(fN, false);

        int car=0;
        String vocales="aeiou";
        car=fR.read();
        while(car!=-1) {
            if (Character.toLowerCase((char)car)=='a'||Character.toLowerCase((char)car)=='e'||Character.toLowerCase((char)car)=='i'
                    ||Character.toLowerCase((char)car)=='o'||Character.toLowerCase((char)car)=='u'){
                int posicion=vocales.indexOf(Character.toLowerCase((char)car))+1;
                if (posicion>=vocales.length()){
                    posicion=0;
                }
                if (Character.isLowerCase((char) car)){
                    car=vocales.charAt(posicion);
                }else{
                    car=Character.toUpperCase(vocales.charAt(posicion));
                }
            }
            fW.write(car);
            car=fR.read();
        }
        fR.close();
        fW.close();
    }

}

