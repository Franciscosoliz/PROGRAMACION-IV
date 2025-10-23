void main() {
  print("Condicionales - Tema: Taller Mecanico");

  int autosEnCola = 2;

  if (autosEnCola > 2) {
    print('Hay mas de 2 autos esperando reparacion');
  }
  if (autosEnCola < 2) {
    print('Hay menos de 2 autos en espera');
  }
  if (autosEnCola == 2) {
    print('Hay exactamente 2 autos en cola');
  } else {
    print('No hay 2 autos en cola');
  }

  int mecanicosDisponibles = 2;

  if (mecanicosDisponibles > 2) {
    print('Hay mas de 2 mecanicos trabajando');
  } else if (mecanicosDisponibles < 2) {
    print('Hay pocos mecanicos disponibles');
  } else {
    print('Hay exactamente 2 mecanicos disponibles');
  }

  int horasTrabajadas = 8;
  String estadoTurno = horasTrabajadas >= 8 ? 'Turno completo' : 'Turno incompleto';
  print("Estado del turno: $estadoTurno");
}
