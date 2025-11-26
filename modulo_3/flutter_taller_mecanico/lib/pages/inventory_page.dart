import 'package:flutter/material.dart';

class InventoryPage extends StatelessWidget {
  const InventoryPage({super.key});

  final List<Map<String, dynamic>> parts = const [
    {'name': 'Filtro de Aceite (5W-30)', 'stock': 45},
    {'name': 'Pastillas de Freno', 'stock': 12},
    {'name': 'Bujías Iridium', 'stock': 8},
    {'name': 'Batería 12V', 'stock': 25},
    {'name': 'Refrigerante G12', 'stock': 5},
    {'name': 'Aceite Sintético 10W-40', 'stock': 30},
    {'name': 'Llantas R16', 'stock': 15},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
        padding: const EdgeInsets.all(16.0),
        itemCount: parts.length,
        itemBuilder: (context, index) {
          final part = parts[index];
          final stockLevel = part['stock'] as int;
          // Lógica de color: Rojo (<10), Naranja (10-19), Verde (>=20)
          final stockColor = stockLevel < 10 ? Colors.red : (stockLevel < 20 ? Colors.orange : Colors.green);

          return Card(
            margin: const EdgeInsets.only(bottom: 10),
            child: ListTile(
              leading: Icon(Icons.settings_suggest, color: stockColor),
              title: Text(part['name'] as String, style: const TextStyle(fontWeight: FontWeight.bold)),
              subtitle: const Text('Proveedor: AutoParts S.A.'),
              trailing: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  Text('Stock', style: Theme.of(context).textTheme.labelSmall),
                  Text('$stockLevel', style: TextStyle(color: stockColor, fontSize: 18, fontWeight: FontWeight.bold)),
                ],
              ),
              onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Detalle de ${part['name']}')),
                );
              },
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Añadir nueva pieza al inventario...')),
          );
        },
        tooltip: 'Añadir Nueva Pieza',
        child: const Icon(Icons.add),
      ),
    );
  }
}