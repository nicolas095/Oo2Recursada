package ejercicio2;

//Como cada clase compartia tanto variables como metodos decidimos crear una superclase llamada Empleado declarandola como abstracta
//para conservar el polimorfismo de sus subclases y todos los atributos en comun elevarlos a la super clase.

abstract class Empleado{
	protected String nombre;
	protected String apellido;
	protected double sueldoBasico;
	
	public Empleado(String nombre,String apellido, double sueldo) {
		this.nombre= nombre;
		this.apellido = apellido;
		this.sueldoBasico = sueldo;
	}
	
	public abstract double sueldo();
}

//es necesario modificar la incializacion de los atributos en 0 ?
//Es necesario crear otra super clase que sea solo para Empleado Temporario y planta porque tienen otro atributo en comun 
class EmpleadoTemporario extends Empleado{
	
	public double horasTrabajadas;
	public int cantidadHijos;
	
	public EmpleadoTemporario(double horasTrabajadas, int cantidadHijos,String nombre,String apellido, double sueldo) {
		super(nombre,apellido,sueldo);
		this.horasTrabajadas= horasTrabajadas;
		this.cantidadHijos=cantidadHijos;
	}
// ......
	public double sueldo() {
		return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000)
				- (this.sueldoBasico * 0.13);
	}
}

class EmpleadoPlanta extends Empleado{

	public int cantidadHijos = 0;
	
	public EmpleadoPlanta( int cantidadHijos,String nombre,String apellido, double sueldo) {
		super(nombre,apellido,sueldo);
		this.cantidadHijos=cantidadHijos;
	}

// ......
	public double sueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}
}

class EmpleadoPasante extends Empleado{
	
	public EmpleadoPasante(String nombre,String apellido, double sueldo) {
		super(nombre,apellido, sueldo);
	}

// ......
	public double sueldo() {
		return this.sueldoBasico - (this.sueldoBasico * 0.13);
	}
}
