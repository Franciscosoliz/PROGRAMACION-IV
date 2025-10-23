void main() {
  print("Tipos de variables en Dart - Tema: Taller Mecanico");

  final String nombreTaller = "Taller Mecanico";
  print(nombreTaller);

  String mecanicoPrincipal = "Carlos";
  mecanicoPrincipal = "Francisco";
  print("Mecanico principal: $mecanicoPrincipal");

  const String especialidad = "Reparacion de motores";
  print("Especialidad: $especialidad");

  bool abierto = true;
  abierto = false;
  print("El taller esta abierto?: $abierto");

  int autosEnReparacion = 5;
  print("Autos en reparacion: $autosEnReparacion");

  List<String> servicios = ["Cambio de aceite", "Alineacion", "Revision de frenos"];
  print("Servicios disponibles: $servicios");

  final repuestos = <String>["Filtro de aceite", "Bujias", "Pastillas de freno"];
  print("Repuestos en inventario: $repuestos");

  print("Impresion en varias lineas:");
  print("""
  Taller: $nombreTaller
  Mecanico principal: $mecanicoPrincipal
  Autos en reparacion: $autosEnReparacion
  Servicios: $servicios
  Repuestos: $repuestos
  """);
}
