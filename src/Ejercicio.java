import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
		aListHashSet();
	}
	
	public static void aListHashSet() {
		//Forma ArrayList + HashSet
				Scanner sc = new Scanner(System.in);
				String nombre="";
				ArrayList <Animal> alist= new ArrayList <Animal> ();
				System.out.println("Animal: ");
				nombre=sc.nextLine();
				while(!nombre.equalsIgnoreCase("fin")) {
					Animal a = new Animal(nombre);
					alist.add(a);
					System.out.println("Animal: ");
					nombre=sc.nextLine();
				}
				
				HashSet<Animal> hS = new HashSet <Animal>(alist);
				
				System.out.println("Animales repetidos: "+ (alist.size()-hS.size()));
				
				sc.close();
	}
	
}
