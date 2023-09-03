public void imprimirValores() {
    int totalEdades = 0;
    double promedioEdades = 0;
    double totalSalarios = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
        totalSalarios = totalSalarios + empleado.getSalario();
    }
    promedioEdades = totalEdades / personal.size();
    String message = String.format("El promedio de las edades es %s y el
    total de salarios es %s", promedioEdades, totalSalarios);
    System.out.println(message);
}

//Solucion

//1) Metodo Largo soluciono con Extract Method sobre los mensajes


public void imprimirValores() {
    int totalEdades = 0;
    double promedioEdades = 0;
    double totalSalarios = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
        totalSalarios = totalSalarios + empleado.getSalario();
    }
    promedioEdades = totalEdades / personal.size();
    this.print(totalEdades,promedioEdades,totalSalarios);
}

public String print(int totalEdades, double promedioEdades, double totalSalarios){
   String message = String.format("El promedio de las edades es %s y el
    total de salarios es %s", promedioEdades, totalSalarios);
    System.out.println(message); 
}

//2) Reemplar el for usando Stream para recorrer mas eficientemente la coleccion de empleados.

public void imprimirValores() {
    int totalEdades = 0;
    double promedioEdades = 0;
    double totalSalarios = 0;
    this.personal.stream().map(empleado -> totalEdades+=empleado.getEdad(), totalSalarios+=empleado.getSalario()).orElse(0);
    promedioEdades = totalEdades / personal.size();
    this.print(totalEdades,promedioEdades,totalSalarios);
}

public String print(int totalEdades, double promedioEdades, double totalSalarios){
   String message = String.format("El promedio de las edades es %s y el
    total de salarios es %s", promedioEdades, totalSalarios);
    System.out.println(message); 
}