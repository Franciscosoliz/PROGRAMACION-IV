void main() {
  print("Maps e Iterables - Tema: Taller Mecanico");

  final autos = [1, 2, 3, 3, 5, 5, 5, 7, 7, 8, 9, 10];

  print("Lista original de autos recibidos: $autos");
  print("Total de autos recibidos: ${autos.length}");
  print("Auto en la posicion 4: ${autos[4]}");
  print("Primer auto recibido: ${autos.first}");

  final autosReverso = autos.reversed;
  print("Reverso de la lista de autos: $autosReverso");

  print("Lista (reversa convertida): ${autosReverso.toList()}");

  print("Set (autos unicos): ${autosReverso.toSet()}");
}
