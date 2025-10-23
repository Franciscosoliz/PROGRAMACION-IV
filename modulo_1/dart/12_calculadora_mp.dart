void main() {
  final CalculadoraCostos calcular = CalculadoraCostos(servicio1: 70, servicio2: 50);
  
  print("Suma de costos: ${calcular.suma()} dolares");
  print("Diferencia de costos: ${calcular.resta()} dolares");
  print("Multiplicacion de costos: ${calcular.multiplicacion()}");
  print("Division de costos: ${calcular.division()}");

}

class CalculadoraCostos {
  double servicio1 = 0.0;
  double servicio2 = 0.0;

  CalculadoraCostos({required this.servicio1, required this.servicio2});

  double suma() {
    return this.servicio1 + this.servicio2;
  }

  double resta() {
    return this.servicio1 - this.servicio2;
  }

  double multiplicacion() {
    return this.servicio1 * this.servicio2;
  }

  double division() {
    return this.servicio1 / this.servicio2;
  }
}
