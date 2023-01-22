import java.util.Objects;

public class Animal {
	String nombre="";
	
	Animal(String nombre){
		this.nombre=nombre;
	}
	
	public boolean equals (Object objeto) {
		if (objeto instanceof Animal) {
			Animal a = (Animal)objeto;
			return nombre.equals(a.nombre);
		}else
			return false;
		}
	
	public int hashCode() {
		return Objects.hash(nombre);
	}

}
