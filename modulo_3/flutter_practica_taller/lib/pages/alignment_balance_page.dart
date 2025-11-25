import 'package:flutter/material.dart';

class AlignmentBalancePage extends StatefulWidget {
  @override
  _AlignmentBalancePageState createState() => _AlignmentBalancePageState();
}

class _AlignmentBalancePageState extends State<AlignmentBalancePage> {
  String vehicleType = "Auto";
  String serviceType = "Solo alineación";
  int tires = 2;

  double vehiclePrice(String type) {
    switch (type) {
      case "Auto": return 10;
      case "Camioneta": return 15;
      case "Camión": return 25;
      default: return 0;
    }
  }

  double servicePrice(String type) {
    switch (type) {
      case "Solo alineación": return 8;
      case "Solo balanceo": return 5;
      case "Ambos": return 12;
      default: return 0;
    }
  }

  String classifyJob(double total) {
    if (total < 50) return "Trabajo pequeño";
    if (total <= 100) return "Trabajo medio";
    return "Trabajo grande";
  }

  @override
  Widget build(BuildContext context) {
    double total = vehiclePrice(vehicleType) + (servicePrice(serviceType) * tires);

    return Scaffold(
      appBar: AppBar(title: Text("Alineación y Balanceo")),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            DropdownButton<String>(
              value: vehicleType,
              items: ["Auto", "Camioneta", "Camión"].map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
              onChanged: (v) => setState(() => vehicleType = v!),
            ),

            DropdownButton<String>(
              value: serviceType,
              items: ["Solo alineación", "Solo balanceo", "Ambos"]
                  .map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
              onChanged: (v) => setState(() => serviceType = v!),
            ),

            Slider(
              value: tires.toDouble(),
              min: 2,
              max: 6,
              divisions: 4,
              label: "$tires llantas",
              onChanged: (v) => setState(() => tires = v.toInt()),
            ),

            SizedBox(height: 20),
            Text("Total: \$${total.toStringAsFixed(2)}", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
            SizedBox(height: 10),
            Text("Clasificación: ${classifyJob(total)}", style: TextStyle(fontSize: 18)),
          ],
        ),
      ),
    );
  }
}
