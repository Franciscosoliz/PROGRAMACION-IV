import 'package:flutter/material.dart';

class ClientsPage extends StatelessWidget {
  const ClientsPage({super.key});

  final List<Map<String, String>> clients = const [
    {'name': 'Ricardo Soto', 'phone': '555-1234', 'vehicle': 'Toyota Hilux'},
    {'name': 'Elena Vargas', 'phone': '555-5678', 'vehicle': 'Honda Civic'},
    {'name': 'Javier López', 'phone': '555-9012', 'vehicle': 'Ford F-150'},
    {'name': 'Marta Gómez', 'phone': '555-3333', 'vehicle': 'Chevrolet Spark'},
    {'name': 'Andrés Díaz', 'phone': '555-4444', 'vehicle': 'Mazda CX-5'},
  ];

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      padding: const EdgeInsets.all(16.0),
      itemCount: clients.length,
      itemBuilder: (context, index) {
        final client = clients[index];
        return Card(
          margin: const EdgeInsets.only(bottom: 10),
          elevation: 3,
          child: ListTile(
            leading: const CircleAvatar(
              backgroundColor: Colors.blueGrey,
              child: Icon(Icons.person, color: Colors.white),
            ),
            title: Text(client['name']!, style: const TextStyle(fontWeight: FontWeight.bold)),
            subtitle: Text('Vehículo: ${client['vehicle']} | Teléfono: ${client['phone']}'),
            trailing: IconButton(
              icon: const Icon(Icons.call, color: Colors.green),
              onPressed: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Llamando a ${client['name']}...'))
                );
              },
            ),
            onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Ver historial de servicio de ${client['name']}...'))
                );
              },
          ),
        );
      },
    );
  }
}