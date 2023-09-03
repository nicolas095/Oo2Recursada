/**
* Retorna el límite de crédito del cliente
*/
protected double lmtCrdt() {}
/**
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {}
/**
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtCbE(LocalDate f1, LocalDate f2) {}


//Se puede ver que la definicion de cada metodo es poco clara por lo tanto para solucionar dicho mal olor debemos utilizar Rename Method para cambiar el nombre de cada metodo
//y renombrar los parametros ya que son poco representativos.

/**
* Retorna el límite de crédito del cliente
*/
protected double limiteDeCredito() {}
/**
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double montoFacturado(LocalDate fechaDesde, LocalDate fechaHasta) {}
/**
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
protected double montoCobrado(LocalDate fechaDesde, LocalDate fechaHasta) {}