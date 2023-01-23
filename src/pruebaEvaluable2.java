import java.util.ArrayList;
import java.util.HashMap;

/*Empezamos con un HashMap, con el que vamos a hacer un control <String,Integer> ej:(FX378,95(Tiempo))
 * Metodo para añadir un vuel ---> Si ya esta ese vuelo da error (no imprime nada salvo el mensaje de error)
 * MEtodo para consultar un vuelo, si no existe da Error (no imprime nada salvo el mensaje de error)
 * Metodo para lisar los vuelos  FX378 -- 95 minutos
 * El main Añadir 6 vuelos,Uno ya existente, consultar un vuelo exixstenete y otro que no, Listado de vuelos oredenado por vuelos
 * Ninguno de los metodos solicita nada por pantalla*/
public class pruebaEvaluable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap h = new HashMap <String,Integer> ();
		int cont=0;

		
		
			anadir(h,12,"FW1");
			anadir(h,24,"FW2");
			anadir(h,33,"FW3");
			anadir(h,47,"FW4");
			anadir(h,54,"FW5");
			anadir(h,5,"FW5");//Vuelo que ya existe
			
			
			consultar(h,"FW4");
			consultar(h,"FW8");//Vuelo no existe
			

			listaVuelos(h);
		

	}
	
	
	
	
	
	public static void anadir(HashMap<String,Integer> a, int b, String c) {
		

		if(!a.containsKey(c)){
			a.put(c,b);
		}else {
			if(a.containsKey(c)){
				System.out.println("Error vuelo ya existente");
			}
		}
		
	
		
		
	}
	
	public static void consultar(HashMap<String,Integer> a,String clave) {
		
		int b = 0;
		
		if(a.containsKey(clave)) {
			b=a.get(clave);
			System.out.println("El vuelo es "+clave+" y tiene una duracion de "+ b+" minutos");
		}else {
			if(!a.containsKey(clave)) {
				System.out.println("Error el vuelo no existe");
			}
		}
		
		
	}

	public static void listaVuelos(HashMap<String,Integer> vuelos) {
		if (!vuelos.isEmpty()) {
			final int TAM = vuelos.size();

            String[] claves = new String[TAM];
			int[] duracion = new int[TAM];

			ArrayList<String> clavesA = new ArrayList<>(vuelos.keySet());
			ArrayList<Integer> duracionA = new ArrayList<>(vuelos.values());


			for (int i = 0; i < TAM; i++)
				System.out.println(clavesA.get(i) + '-' + duracionA.get(i) + " minutos");
		} else
			System.out.println("No hay vuelos registrados");
	}

}
