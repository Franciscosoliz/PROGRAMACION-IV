import 'package:flutter/material.dart';

class QuickDiagnosisPage extends StatefulWidget {
  @override
  _QuickDiagnosisPageState createState() => _QuickDiagnosisPageState();
}

class _QuickDiagnosisPageState extends State<QuickDiagnosisPage> {
  String symptom = "Vibración al frenar";
  int km = 0;
  String result = "";

  String problem(String s) {
    switch (s) {
      case "Vibración al frenar": return "Discos de freno desgastados";
      case "Humo azul del escape": return "Consumo de aceite";
      case "Ralentí inestable": return "Bujías o inyectores defectuosos";
      case "Ruido metálico al arrancar": return "Problema en el motor de arranque";
      default: return "N/A";
    }
  }

  String rangeMessage(int km) {
    if (km <= 5000) return "Moderado: mantenimiento recomendado pronto.";
    if (km <= 15000) return "Importante: servicio necesario.";
    return "Crítico: riesgo de falla grave.";
  }

  void diagnose() {
    setState(() {
      result =
          "Problema probable: ${problem(symptom)}\nRecomendación: ${rangeMessage(km)}";
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Diagnóstico Rápido")),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            DropdownButton<String>(
              value: symptom,
              items: [
                "Vibración al frenar",
                "Humo azul del escape",
                "Ralentí inestable",
                "Ruido metálico al arrancar"
              ].map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
              onChanged: (v) => setState(() => symptom = v!),
            ),

            TextField(
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: "Kilómetros desde el último mantenimiento"),
              onChanged: (v) => km = int.tryParse(v) ?? 0,
            ),

            SizedBox(height: 20),
            ElevatedButton(
              onPressed: diagnose,
              child: Text("Ver diagnóstico"),
            ),

            SizedBox(height: 30),
            Text(result, style: TextStyle(fontSize: 18)),
          ],
        ),
      ),
    );
  }
}
