import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class TravelHomePage extends StatelessWidget {
  const TravelHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Opciones de Viaje'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: ListView(
          children: [
            ElevatedButton(
              onPressed: () => context.go('/photos'),
              child: const Text('Carrusel de fotos'),
            ),
            const SizedBox(height: 12),

            ElevatedButton(
              onPressed: () => context.go('/videos'),
              child: const Text('Carrusel de videos MP4'),
            ),
            const SizedBox(height: 12),

            ElevatedButton(
              onPressed: () => context.go('/dias'),
              child: const Text('Días de Viaje'),
            ),
          ],
        ),
      ),
    );
  }
}
