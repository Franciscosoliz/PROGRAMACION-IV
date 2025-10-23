void main() {
  final Auto auto1 = Auto(nombre: 'Toyota Corolla', servicio: 'Cambio de aceite');
  print(auto1);
  print(auto1.nombre);
  print(auto1.servicio);
}

class Auto {
  String nombre = "";
  String servicio = "";
  
  Auto({required this.nombre, this.servicio = "Sin servicio asignado"});

  @override
  String toString() {
    return "$nombre - $servicio";
  }
}
