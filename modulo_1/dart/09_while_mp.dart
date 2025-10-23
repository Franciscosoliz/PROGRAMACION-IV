void main() {
  print("Calculo de servicios - Taller Mecanico");

  int n = 10;
  int precioServicio = 30;
  int i = 0;

  print("Calculo con while:");
  while (i < n) {
    i++;
    print("Auto $i * $precioServicio = ${i * precioServicio} dolares");
  }

  i = 1;
  print("Calculo con do-while:");
  do {
    print("Auto $i * $precioServicio = ${i * precioServicio} dolares");
    i++;
  } while (i < n);
}
