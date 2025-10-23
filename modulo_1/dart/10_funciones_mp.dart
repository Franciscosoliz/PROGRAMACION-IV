void main() {
  print(greetTaller());
  print(sumaServicios(3, 4));
  print(calcularCostoOpcional(6, 8));
  print(calcularCostoOpcional(8));
  print(saludarMecanico(name: "Soliz", message: "Bienvenido al taller"));
  print(saludarMecanico(name: "Francisco"));
}

String greetTaller() => "Bienvenidos al Taller Mecanico";

int sumaServicios(int a, int b) => a + b;

int calcularCostoOpcional(int a, [int b = 0]) {
  return a + b;
}

String saludarMecanico({required String name, String message = "Hola"}) {
  return '$message, $name';
}
