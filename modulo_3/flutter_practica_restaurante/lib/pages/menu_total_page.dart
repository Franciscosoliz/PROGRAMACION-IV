import 'package:flutter/material.dart';

class MenuTotalPage extends StatefulWidget {
  const MenuTotalPage({super.key});

  @override
  State<MenuTotalPage> createState() => _MenuTotalPageState();
}

class _MenuTotalPageState extends State<MenuTotalPage> {
  final TextEditingController priceController = TextEditingController();
  final TextEditingController qtyController = TextEditingController();

  String selectedType = "Nuevo";
  String result = "";

  double getDiscount(String type) {
    switch (type) {
      case "Frecuente":
        return 0.08;
      case "Corporativo":
        return 0.12;
      default:
        return 0.0;
    }
  }

  void calculateTotal() {
    double? price = double.tryParse(priceController.text);
    int? qty = int.tryParse(qtyController.text);

    if (price == null || qty == null || price <= 0 || qty <= 0) {
      setState(() {
        result = "Ingrese valores válidos para precio y cantidad.";
      });
      return;
    }

    double subtotal = price * qty;
    double discountRate = getDiscount(selectedType);
    double discountAmount = subtotal * discountRate;
    double total = subtotal - discountAmount;

    setState(() {
      result = """
Subtotal: \$${subtotal.toStringAsFixed(2)}
Descuento: ${(discountRate * 100).toStringAsFixed(0)}%
Monto de descuento: \$${discountAmount.toStringAsFixed(2)}
Total a pagar: \$${total.toStringAsFixed(2)}
""";
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Cálculo Menú del Día")),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [

            TextField(
              controller: priceController,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Precio base del menú",
              ),
            ),

            const SizedBox(height: 15),

            TextField(
              controller: qtyController,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Cantidad",
              ),
            ),

            const SizedBox(height: 15),

            DropdownButtonFormField(
              value: selectedType,
              items: const [
                DropdownMenuItem(value: "Nuevo", child: Text("Nuevo (0%)")),
                DropdownMenuItem(value: "Frecuente", child: Text("Frecuente (8%)")),
                DropdownMenuItem(value: "Corporativo", child: Text("Corporativo (12%)")),
              ],
              onChanged: (value) {
                setState(() {
                  selectedType = value!;
                });
              },
              decoration: const InputDecoration(labelText: "Tipo de cliente"),
            ),

            const SizedBox(height: 25),

            ElevatedButton(
              onPressed: calculateTotal,
              child: const Text("Calcular total"),
            ),

            const SizedBox(height: 25),

            Text(
              result,
              style: const TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}
