import java.util.HashSet;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

/**/
public class PruebaEvaluable {

	public static void main(String[] args) {
		ArrayList <String> animales = new ArrayList <String>();
		Scanner sc = new Scanner(System.in);
		String ani = "";
		String fin = "fin";
		String FIN = "FIN";
		System.out.println("Animal:");
		ani=sc.nextLine();
		
		
		while(!ani.equals(fin) && !ani.equals(FIN)){
			animales.add(ani);
			ani=sc.nextLine();
		}
		
		HashSet <String> an = new HashSet <String>(animales);
		imp(an,animales);
		

	}
	
	public static void imp(Collection <String> lista, ArrayList <String> an) {
	
		
		if(lista.isEmpty()) 
			System.out.println("Esta vacia");
		else {
		
			for(String a : lista) {
				System.out.println(a);
				System.out.println("-----------");
			}
			int hash= lista.size();
			int array = an.size();
			
			System.out.printf("Animales repetidos: %d",array-hash);
			
		}
		
	}

}
