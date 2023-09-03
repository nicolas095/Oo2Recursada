package ejercicio2;

class Ejercicio2_5 {

}

class Supermercado {
	public void notificarPedido(long nroPedido, Cliente cliente) {
		String notificacion = MessageFormat.format("Estimado cliente, se le	informa que hemos "
				+ "recibido su pedido con número {0}, el cual será enviado a "
				+ "la dirección {1}", new Object[] { nroPedido, cliente.getDireccionFormateada()});
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println(notificacion);
}
}

class Cliente {
	private Direccion direccion;
	public String getDireccionFormateada() {
		return this.direccion.formatearDireccion();
		}
}

/**(i) Feature Envy,
(ii) Se utiliza Move Method moviendo getDireccionFormateada a la clase Direccion ya que dicha clase posee toda la informacion .
(iii) Resolucion
*/

class Direccion{ //Creamos la clase direccion porque esta en el UML pero no la implementaron, esta bien ?

	private String localidad;
	private String calle;
	private int numero;
	private String departamento;
	
	public String getLocalidad() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDepartamento() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumero() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCalle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String formatearDireccion() {
		return
				this.localidad + ", " +
				this.calle + ", " +
				this.numero + "," +
				this.departamento
				;
	}
}