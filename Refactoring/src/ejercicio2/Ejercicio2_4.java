package ejercicio2;

import java.util.List;

public class Ejercicio2_4 {

}

class Producto {
	private String nombre;
	private double precio;

	public double getPrecio() {
		return this.precio;
	}
}

class ItemCarrito {
	private Producto producto;
	private int cantidad;

	public Producto getProducto() {
		return this.producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}
}

class Carrito {
	private List<ItemCarrito> items; // preguntar si el uml esta mal porque falta el * en items

	public double total() {
		return this.items.stream().mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad()).sum();
	}
}

/**(i) Feature Envy,
(ii) Se utiliza Move Method debido a que el stream dentro de Carrito esta calculando el total por cada ItemCarrito cuando deberia
ser ItemCarrito quien te devuelva el total por cada producto .
(iii) Resolucion
*/

class Producto {
	private String nombre;
	private double precio;

	public double getPrecio() {
		return this.precio;
	}
}

class ItemCarrito {
	private Producto producto;
	private int cantidad;

	public Producto getProducto() {
		return this.producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}
	
	public double totalPorProducto() {
		return this.producto.getPrecio() * this.getCantidad();
	}
}

class Carrito {
	private List<ItemCarrito> items; // preguntar si el uml esta mal porque falta el * en items

	public double total() {
		return this.items.stream().mapToDouble(item -> item.totalPorProducto()).sum();
	}
}

