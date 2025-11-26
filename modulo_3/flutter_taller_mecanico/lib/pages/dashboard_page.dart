import 'package:flutter/material.dart';

class DashboardPage extends StatelessWidget {
  const DashboardPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: ListView(
        children: <Widget>[
          Text(
            'Resumen General del Taller',
            style: Theme.of(context).textTheme.headlineMedium!.copyWith(fontWeight: FontWeight.bold),
          ),
          const Divider(height: 30),
          
          _buildMetricCard(
            context,
            title: 'Órdenes Activas',
            value: '18',
            icon: Icons.access_time_filled,
            color: Colors.orange.shade700,
          ),
          _buildMetricCard(
            context,
            title: 'Técnicos Ocupados',
            value: '7 / 9',
            icon: Icons.group,
            color: Colors.blue.shade700,
          ),
          _buildMetricCard(
            context,
            title: 'Ganancia Estimada Hoy',
            value: '\$ 1,250',
            icon: Icons.attach_money,
            color: Colors.green.shade700,
          ),
          const SizedBox(height: 20),
          Text(
            'Tareas Pendientes',
            style: Theme.of(context).textTheme.titleLarge!.copyWith(fontWeight: FontWeight.bold),
          ),
          const ListTile(
            leading: Icon(Icons.warning, color: Colors.red),
            title: Text('Filtro de Aceite (Bajo Stock)'),
            subtitle: Text('Revisar inventario urgente.'),
          ),
          const ListTile(
            leading: Icon(Icons.directions_car, color: Colors.blue),
            title: Text('Próxima Cita: Elena V.'),
            subtitle: Text('Mañana, 10:00 AM.'),
          ),
        ],
      ),
    );
  }

  // Widget auxiliar para construir tarjetas de métricas
  Widget _buildMetricCard(BuildContext context, {required String title, required String value, required IconData icon, required Color color}) {
    return Card(
      margin: const EdgeInsets.only(bottom: 12),
      elevation: 4,
      child: ListTile(
        leading: Icon(icon, size: 40, color: color),
        title: Text(title, style: Theme.of(context).textTheme.titleLarge),
        trailing: Text(value, style: Theme.of(context).textTheme.headlineSmall!.copyWith(color: color, fontWeight: FontWeight.bold)),
      ),
    );
  }
}