package ejercicio2;

public class Ejercicio2_2 {

}

//(i) indique el mal olor,
//(ii) indique el refactoring que lo corrige,
//(iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según
//corresponda).
//Si vuelve a encontrar un mal olor, retorne al paso (i).

/**
 * I) Feature Envy
 * II) Para corregir el mal olor usamos Move Method de Juego a Jugador para que cada Jugador aumente y decremente su puntuacion
 * ya que dicho atributo lo posee el Jugador y no el Juego.
 */
class Juego {
	// ......
	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}
}

class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0;
}

/**
 * III) Resultado
 */

class Juego {
	// ......
	public void incrementar(Jugador j) {
		j.incrementar();
	}

	public void decrementar(Jugador j) {
		j.decrementar();
	}
}

class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0; // se deberia sacar el 0 usando algun refactoring?
	
	public void incrementar() {
		this.puntuacion = this.puntuacion + 100;
	}

	public void decrementar() {
		this.puntuacion = this.puntuacion - 50;
	}
}

/**
 * I) Se rompe el encapsulamiento del objeto Jugador debido a que los atributos son publicos.
 * II) Para corregir el mal olor usamos Encapsulate Field que permite modificar la privacidad de cada atributo , donde la cambiaremos a
 * privado y luego segun el ejercicio se deberan crear los getters y setters correspondientes para acceder a las variables.
 * III)
 */
class Jugador {
	private String nombre;
	private String apellido;
	private int puntuacion = 0;
	
	public void incrementar() {
		this.puntuacion = this.puntuacion + 100;
	}

	public void decrementar() {
		this.puntuacion = this.puntuacion - 50;
	}
}
