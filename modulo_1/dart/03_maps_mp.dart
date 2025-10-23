void main() {
  print("Maps - Tema: Taller Mecanico");

  final Map<String, dynamic> taller = {
    'nombre': 'Taller Mecanico',
    'autosEnReparacion': 5,
    'estaAbierto': true,
    'servicios': <String>['Cambio de aceite', 'Alineacion', 'Revision de frenos'],
    'fotos': {
      1: 'src/taller1.jpg',
      2: 'src/taller2.jpg'
    }
  };

  print(taller);
  print(taller['nombre']);
  print(taller['fotos']);
  print(taller['estaAbierto']);
}
