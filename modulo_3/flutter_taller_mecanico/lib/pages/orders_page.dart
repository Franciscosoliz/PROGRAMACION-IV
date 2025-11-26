import 'package:flutter/material.dart';
import '../data_models.dart'; // Importamos el modelo de datos

class OrdersPage extends StatelessWidget {
  OrdersPage({super.key});

  final List<ServiceOrder> orders = [
    ServiceOrder(id: 101, vehiclePlate: 'PQT-789', description: 'Cambio de aceite y filtros.', priority: 'Alta'),
    ServiceOrder(id: 102, vehiclePlate: 'ABC-123', description: 'Reparación de embrague.', priority: 'Alta'),
    ServiceOrder(id: 103, vehiclePlate: 'GTH-456', description: 'Revisión general.', priority: 'Media', isCompleted: true),
    ServiceOrder(id: 104, vehiclePlate: 'XY-001', description: 'Cambio de amortiguadores.', priority: 'Media'),
    ServiceOrder(id: 105, vehiclePlate: 'DFG-555', description: 'Diagnóstico eléctrico.', priority: 'Baja'),
    ServiceOrder(id: 106, vehiclePlate: 'MNO-321', description: 'Alineación y balanceo.', priority: 'Baja'),
    ServiceOrder(id: 107, vehiclePlate: 'JKL-654', description: 'Instalación de luces LED.', priority: 'Media'),
  ];

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      padding: const EdgeInsets.all(16.0),
      itemCount: orders.length,
      itemBuilder: (context, index) {
        final order = orders[index];
        final priorityColor = order.priority == 'Alta' ? Colors.red : (order.priority == 'Media' ? Colors.orange : Colors.blue);
        
        return Card(
          margin: const EdgeInsets.only(bottom: 10),
          // Resalta las órdenes completadas con un color suave
          color: order.isCompleted ? Colors.lightGreen.shade50 : null,
          elevation: 2,
          child: ListTile(
            leading: Icon(
              order.isCompleted ? Icons.check_circle : Icons.build,
              color: order.isCompleted ? Colors.green.shade700 : priorityColor,
            ),
            title: Text('Orden #${order.id} - ${order.vehiclePlate}', style: const TextStyle(fontWeight: FontWeight.bold)),
            subtitle: Text(order.description),
            trailing: Chip(
              label: Text(order.isCompleted ? 'Finalizada' : order.priority),
              backgroundColor: order.isCompleted ? Colors.green.shade200 : priorityColor.withOpacity(0.5),
              labelStyle: TextStyle(color: order.isCompleted ? Colors.black : Colors.white),
            ),
            onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Abriendo detalle de la orden ${order.id}')),
                );
              },
          ),
        );
      },
    );
  }
}