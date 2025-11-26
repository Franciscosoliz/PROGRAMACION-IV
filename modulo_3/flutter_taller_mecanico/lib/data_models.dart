// Contiene todos los modelos de datos para la aplicación de Taller Mecánico.

class Vehicle {
  final String plate;
  final String model;
  final String owner;

  Vehicle({required this.plate, required this.model, required this.owner});
}

class ServiceOrder {
  final int id;
  final String vehiclePlate;
  final String description;
  final String priority;
  final bool isCompleted;

  ServiceOrder({
    required this.id,
    required this.vehiclePlate,
    required this.description,
    required this.priority,
    this.isCompleted = false,
  });
}