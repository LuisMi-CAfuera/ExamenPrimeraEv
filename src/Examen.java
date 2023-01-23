import java.io.*;
import java.sql.*;

public class Examen {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        short idD = 0;
        String nom_dep="";
        String bloque = "";
        float presupuesto = 0;


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?serverTimeZone=UTC","root", "afuera");

        Statement sentencia = conex.createStatement();

        File f = new File("C:\\Users\\AlumnoM\\Documents\\DAM2-AccesoADatos\\Examen2Eva\\src\\dptosD.dat");

        RandomAccessFile r = new RandomAccessFile(f,"r");

        String sql = "INSERT INTO dptos VALUES ("+idD+",'"+nom_dep+"','"+bloque+"',"+presupuesto+")";

        try{
            do{
                idD = r.readShort();

                for(int i = 0; i < 15; i++){
                    nom_dep=nom_dep+r.readChar();
                }
                bloque=String.valueOf(r.readChar());

                presupuesto = r.readFloat();

                String sql2 = sql = "SELECT * FROM dptos";
                ResultSet rs = sentencia.executeQuery(sql2);

                if(rs.getShort(1) != idD && rs.getString(2)!= nom_dep){
                    sentencia.executeUpdate(sql);
                }
            }while(true);

        }catch (EOFException e){
            System.out.println("Fin del fichero");
        }catch (Exception e){
            System.out.println(e);
        }

        idD=120;
        nom_dep="ESCUALA";
        bloque="E";
        presupuesto=1000;

        sql = "INSERT INTO dptos VALUES ("+idD+",'"+nom_dep+"','"+bloque+"',"+presupuesto+")";
        sentencia.executeUpdate(sql);

        sql = "SELECT * FROM dptos";

        ResultSet rs = sentencia.executeQuery(sql);

        while (rs.next()){
            System.out.println(rs.getShort(1)+" "+rs.getString(2)+" "+rs.getString(3)
            +" "+rs.getFloat(4));
        }

    }
}
