import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {
    public static void main(String[] args) throws IOException {
        File f1 = new File("trenes.dat");
        RandomAccessFile fR1 = new RandomAccessFile(f1, "r");
        File f2 = new File("reservas.dat");
        RandomAccessFile fR2 = new RandomAccessFile(f2, "r");

        System.out.println("Plazas libres:");
        String id;
        String hora;
        short capMax;
        short cap;
        short capRest;
        boolean flag;

        try{
            do {
                id="";
                hora="";
                flag=true;

                for (int i=0; i<5; i++){
                    id=id+fR1.readChar();
                }
                String trayecto="";
                for (int i=0; i<20; i++){
                    trayecto=trayecto+fR1.readChar();
                }
                for (int i=0; i<5; i++){
                    hora=hora+fR1.readChar();
                }
                capMax= fR1.readShort();
                capRest=capMax;
                try {
                    fR2.seek(0);
                    do {
                        String id2="";
                        for (int i=0; i<5; i++){
                            id2=id2+fR2.readChar();
                        }
                        cap= fR2.readShort();
                        if (id.equals(id2)){
                            capRest= (short) (capMax-cap);
                            flag=false;
                        }
                    }while (flag);
                }catch (EOFException e){
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println(id +" "+ capRest);
            }while (true);
        }catch (EOFException e){
            System.out.println("Final de fichero");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
