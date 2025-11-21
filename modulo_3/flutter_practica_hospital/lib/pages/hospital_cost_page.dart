import 'package:flutter/material.dart';

class HospitalCostPage extends StatefulWidget {
  const HospitalCostPage({super.key});

  @override
  State<HospitalCostPage> createState() => _HospitalCostPageState();
}

class _HospitalCostPageState extends State<HospitalCostPage> {
  // Selects
  String habitacion = 'General';
  String seguro = 'Público';

  // Inputs
  final diasController = TextEditingController();
  final costoBaseController = TextEditingController();

  // Resultado
  double resultado = 0;

  void calcular() {
    double dias = double.tryParse(diasController.text) ?? 0;
    double costoBase = double.tryParse(costoBaseController.text) ?? 0;

    // Multiplicador por tipo de habitación
    double multiplicadorHabitacion = 1;

    if (habitacion == 'Semi-Privada') multiplicadorHabitacion = 1.4;
    if (habitacion == 'Privada') multiplicadorHabitacion = 2;

    // Descuento por tipo de seguro
    double descuento = 0;

    if (seguro == 'Público') descuento = 0.30;
    if (seguro == 'Privado') descuento = 0.50;
    if (seguro == 'Sin seguro') descuento = 0;

    double costoSinDesc = dias * costoBase * multiplicadorHabitacion;
    double costoFinal = costoSinDesc * (1 - descuento);

    setState(() {
      resultado = costoFinal;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Cálculo de Hospitalización")),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Text(
                "4) Cálculo de costo de hospitalización",
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 20),

              // SELECT HABITACIÓN
              const Text(
                "Select 1: Tipo de habitación",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              DropdownButton<String>(
                value: habitacion,
                items: const [
                  DropdownMenuItem(value: "General", child: Text("General")),
                  DropdownMenuItem(value: "Semi-Privada", child: Text("Semi-Privada")),
                  DropdownMenuItem(value: "Privada", child: Text("Privada")),
                ],
                onChanged: (value) => setState(() => habitacion = value!),
              ),

              const SizedBox(height: 20),

              // SELECT SEGURO
              const Text(
                "Select 2: Seguro médico",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              DropdownButton<String>(
                value: seguro,
                items: const [
                  DropdownMenuItem(value: "Público", child: Text("Público")),
                  DropdownMenuItem(value: "Privado", child: Text("Privado")),
                  DropdownMenuItem(value: "Sin seguro", child: Text("Sin seguro")),
                ],
                onChanged: (value) => setState(() => seguro = value!),
              ),

              const SizedBox(height: 25),

              // INPUT DÍAS
              const Text(
                "Input 1: Días de hospitalización",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              TextField(
                controller: diasController,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                ),
              ),

              const SizedBox(height: 25),

              // INPUT COSTO BASE
              const Text(
                "Input 2: Costo diario base",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              TextField(
                controller: costoBaseController,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                ),
              ),

              const SizedBox(height: 30),

              ElevatedButton(
                onPressed: calcular,
                child: const Text("Calcular costo total"),
              ),

              const SizedBox(height: 30),

              Text(
                "Costo total: \$${resultado.toStringAsFixed(2)}",
                style: const TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
