import 'package:flutter/material.dart';

class SettingsPage extends StatelessWidget {
  const SettingsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Text(
            'Configuración del Taller',
            style: Theme.of(context).textTheme.headlineMedium!.copyWith(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 20),
          const Card(
            elevation: 2,
            child: ListTile(
              leading: Icon(Icons.account_circle, color: Colors.blue),
              title: Text('Gestión de Empleados'),
              subtitle: Text('Administrar técnicos, salarios y roles'),
              trailing: Icon(Icons.chevron_right),
            ),
          ),
          const Card(
            elevation: 2,
            child: ListTile(
              leading: Icon(Icons.receipt_long, color: Colors.teal),
              title: Text('Reportes Financieros'),
              subtitle: Text('Generar reportes de ganancias, gastos e impuestos'),
              trailing: Icon(Icons.chevron_right),
            ),
          ),
          const Card(
            elevation: 2,
            child: ListTile(
              leading: Icon(Icons.notifications, color: Colors.orange),
              title: Text('Ajustes de Notificaciones'),
              subtitle: Text('Configurar alertas para citas y bajo stock'),
              trailing: Icon(Icons.chevron_right),
            ),
          ),
          const Card(
            elevation: 2,
            child: ListTile(
              leading: Icon(Icons.cloud_sync, color: Colors.purple),
              title: Text('Copia de Seguridad (Cloud)'),
              subtitle: Text('Estado de la sincronización de datos'),
              trailing: Icon(Icons.chevron_right),
            ),
          ),
          const Spacer(),
          Center(
            child: ElevatedButton.icon(
              onPressed: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Sesión Cerrada (Simulado)')),
                );
              },
              icon: const Icon(Icons.logout),
              label: const Text('Cerrar Sesión'),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.red,
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15)
              ),
            ),
          ),
          const SizedBox(height: 20),
        ],
      ),
    );
  }
}