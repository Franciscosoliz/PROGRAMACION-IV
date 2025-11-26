import 'package:flutter/material.dart';
// Importamos las 5 páginas que se encuentran en la carpeta 'pages'
// Nota: Estos archivos deben existir en lib/pages/ para que la aplicación compile.
import 'pages/dashboard_page.dart';
import 'pages/inventory_page.dart';
import 'pages/orders_page.dart';
import 'pages/clients_page.dart';
import 'pages/settings_page.dart';

void main() {
  // Inicializa la aplicación del Taller Mecánico
  runApp(const TallerMecanicoApp());
}

// 1. Widget raíz de la aplicación (StatelessWidget)
class TallerMecanicoApp extends StatelessWidget {
  const TallerMecanicoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Taller Mecánico',
      debugShowCheckedModeBanner: false, // Oculta la etiqueta "DEBUG"
      theme: ThemeData(
        // Configuración de tema con color primario azul
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
        useMaterial3: true,
      
      ),
      // La pantalla inicial es el contenedor con la navegación inferior
      home: const MainScreenContainer(),
    );
  }
}

// 2. Contenedor principal (StatefulWidget) que maneja la navegación inferior
class MainScreenContainer extends StatefulWidget {
  const MainScreenContainer({super.key});

  @override
  State<MainScreenContainer> createState() => _MainScreenContainerState();
}

class _MainScreenContainerState extends State<MainScreenContainer> {
  // Estado para rastrear el índice de la pestaña seleccionada (0, 1, 2, 3, 4)
  int _selectedIndex = 0;

  // Lista de las 5 pantallas (Widgets)
  // Se usa 'static final' y se quitan todos los 'const' en las llamadas a las páginas
  // para resolver el error de constructor no constante, especialmente OrdersPage.
  static final List<Widget> _screens = <Widget>[
    DashboardPage(),
    InventoryPage(),
    OrdersPage(), 
    ClientsPage(),
    SettingsPage(),
  ];

  // Función para actualizar el índice al tocar un ítem de la barra
  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Taller Móvil 🛠️'),
        backgroundColor: Theme.of(context).colorScheme.primary,
        foregroundColor: Colors.white,
        elevation: 4,
      ),
      // Muestra la pantalla seleccionada del listado '_screens'
      body: _screens[_selectedIndex],
      
      // Barra de Navegación Inferior (BottomNavigationBar)
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(icon: Icon(Icons.dashboard), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.inventory_2), label: 'Stock'),
          BottomNavigationBarItem(icon: Icon(Icons.checklist), label: 'Órdenes'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Clientes'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Ajustes'),
        ],
        currentIndex: _selectedIndex, // Indica qué ítem está activo
        selectedItemColor: Theme.of(context).colorScheme.primary,
        unselectedItemColor: Colors.grey,
        onTap: _onItemTapped, // Maneja el cambio de pestaña
        type: BottomNavigationBarType.fixed, // Mantiene todos los íconos visibles
      ),
    );
  }
}