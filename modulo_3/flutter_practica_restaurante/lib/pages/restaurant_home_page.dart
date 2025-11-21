import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class RestaurantHomePage extends StatelessWidget {
  const RestaurantHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFEF7F4),
      appBar: AppBar(
        title: const Text("Menú Restaurante"),
        backgroundColor: Colors.brown,
        elevation: 0,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              "Seleccione una opción:",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),

            // BOTÓN 1
            MenuButton(
              text: "Total de la cuenta con IVA",
              onTap: () => context.go('/order'),
            ),

            // BOTÓN 2
            MenuButton(
              text: "Calcular propina",
              onTap: () => context.go('/tip'),
            ),

            // BOTÓN 3
            MenuButton(
              text: "Dividir cuenta",
              onTap: () => context.go('/split'),
            ),

            // BOTÓN 4
            MenuButton(
              text: "Menu del Dia",
              onTap: () => context.go('/menu'),
            ),
          ],
        ),
      ),
    );
  }
}

class MenuButton extends StatelessWidget {
  final String text;
  final VoidCallback onTap;

  const MenuButton({
    super.key,
    required this.text,
    required this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 10),
      child: ElevatedButton(
        onPressed: onTap,
        style: ElevatedButton.styleFrom(
          backgroundColor: const Color(0xFFFBE8E4),
          foregroundColor: Colors.brown,
          padding: const EdgeInsets.symmetric(vertical: 18),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(30),
          ),
        ),
        child: Text(
          text,
          style: const TextStyle(fontSize: 18),
        ),
      ),
    );
  }
}
