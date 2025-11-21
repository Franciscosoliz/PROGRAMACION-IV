import 'package:flutter/material.dart';

class PhotoCarouselPage extends StatelessWidget {
  const PhotoCarouselPage({super.key});

  @override
  Widget build(BuildContext context) {
    final List<String> images = [
      'assets/images/foto1.jpg',
      'assets/images/foto2.jpg',
      'assets/images/foto3.jpg',
    ];

    return Scaffold(
      appBar: AppBar(title: const Text('Carrusel de Fotos')),
      body: PageView.builder(
        itemCount: images.length,
        itemBuilder: (_, index) => Image.asset(
          images[index],
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}
