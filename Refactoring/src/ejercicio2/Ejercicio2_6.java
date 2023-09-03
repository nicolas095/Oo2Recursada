package ejercicio2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ejercicio2_6 {

}

class Usuario {
	String tipoSubscripcion;

// ...
	public void setTipoSubscripcion(String unTipo) {
		this.tipoSubscripcion = unTipo;
	}

	public double calcularCostoPelicula(Pelicula pelicula) {
		double costo = 0;
		if (tipoSubscripcion == "Basico") {
			costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
		} else if (tipoSubscripcion == "Familia") {
			costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
		} else if (tipoSubscripcion == "Plus") {
			costo = pelicula.getCosto();
		} else if (tipoSubscripcion == "Premium") {
			costo = pelicula.getCosto() * 0.75;
		}
		return costo;
	}
}

class Pelicula {
	LocalDate fechaEstreno;

// ...
	public double getCosto() {
		return this.costo;
	}

public double calcularCargoExtraPorEstreno(){
// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) )> 30 ? 0 : 300;
}
}


/**(i) Switch Statements,
(ii) Para solucionar el mal olor se refactoriza usando Replace conditional with polymorphism donde cada posible suscripcion se convertira
en una sublcase de Pelicula donde tendran un metodo polimorfico que responda al tipo de suscripcion elegida.
(iii) Resolucion
*/

class Usuario {
	private TipoSuscripcion tipoSubscripcion;
	
// ...
	public void setTipoSubscripcion(String unTipo) {
		this.tipoSubscripcion = unTipo;
	}

	public double calcularCostoPelicula(Pelicula pelicula) {
		return this.tipoSubscripcion.costoPelicula(pelicula);
	}
}

class Pelicula {
	LocalDate fechaEstreno;

// ...
	public double getCosto() {
		return this.costo;
	}

	public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) )> 30 ? 0 : 300; // preguntar si es necesario armar bien este IF
	}
}

interface TipoSuscripcion {
	public double costoPelicula(Pelicula pelicula);
}

class Basico implements TipoSuscripcion{

	@Override
	public double costoPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();;
	}
	
}


class Familia implements TipoSuscripcion{

	@Override
	public double costoPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
	}
	
}

class Plus implements TipoSuscripcion{

	@Override
	public double costoPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return pelicula.getCosto();
	}
	
}

class Premium implements TipoSuscripcion{

	@Override
	public double costoPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return pelicula.getCosto() * 0.75;
	}
	
}

