import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class TipsCalculatorPage extends StatefulWidget {
  const TipsCalculatorPage({super.key});

  @override
  State<TipsCalculatorPage> createState() => _TipsCalculatorPageState();
}

class _TipsCalculatorPageState extends State<TipsCalculatorPage> {
  String tablesCountText = '';
  int tablesCount = 0;

  final List<TextEditingController> tableControllers = [];
  String tipPercentage = '10%';

  String resultText = '';

  // Generar campos para cada mesa
  void generateTables() {
    final count = int.tryParse(tablesCountText) ?? 0;

    if (count <= 0 || count > 10) {
      setState(() {
        resultText = 'Ingrese un número de mesas entre 1 y 10';
        tablesCount = 0;
        tableControllers.clear();
      });
      return;
    }

    tablesCount = count;
    tableControllers.clear();

    for (int i = 0; i < tablesCount; i++) {
      tableControllers.add(TextEditingController());
    }

    setState(() {
      resultText = 'Ingrese el consumo de cada mesa';
    });
  }

  // Calcular propinas
  void calculateTips() {
    if (tablesCount == 0) {
      setState(() {
        resultText = 'Primero genere las mesas';
      });
      return;
    }

    final double percent =
        tipPercentage == '10%' ? 0.10 : tipPercentage == '12%' ? 0.12 : 0.15;

    double totalGeneral = 0;
    List<String> lines = [];

    for (int i = 0; i < tablesCount; i++) {
      final amount =
          double.tryParse(tableControllers[i].text.replaceAll(',', '.')) ?? 0.0;

      final tip = amount * percent;
      totalGeneral += tip;

      lines.add('Mesa ${i + 1}: Propina \$${tip.toStringAsFixed(2)}');
    }

    setState(() {
      resultText = '${lines.join("\n")}\n\n'
          'Propina total: \$${totalGeneral.toStringAsFixed(2)}';
    });

    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(content: Text('Propinas calculadas correctamente')),
    );
  }

  @override
  void dispose() {
    for (final controller in tableControllers) {
      controller.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora de Propinas'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Text(
                'Propinas por mesa (restaurante)',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 12),

              // Número de mesas
              TextField(
                decoration: const InputDecoration(
                  labelText: 'Número de mesas (1 - 10)',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
                onChanged: (value) {
                  tablesCountText = value;
                },
              ),

              const SizedBox(height: 12),

              ElevatedButton(
                onPressed: generateTables,
                child: const Text('Generar mesas'),
              ),

              const SizedBox(height: 16),

              if (tablesCount > 0)
                ListView.builder(
                  shrinkWrap: true,
                  physics: const NeverScrollableScrollPhysics(),
                  itemCount: tablesCount,
                  itemBuilder: (context, index) {
                    return Card(
                      child: Padding(
                        padding: const EdgeInsets.all(12),
                        child: TextField(
                          controller: tableControllers[index],
                          decoration: InputDecoration(
                            labelText: 'Consumo Mesa ${index + 1} (\$)',
                            border: const OutlineInputBorder(),
                          ),
                          keyboardType: TextInputType.number,
                        ),
                      ),
                    );
                  },
                ),

              const SizedBox(height: 16),

              // Dropdown de porcentaje
              if (tablesCount > 0)
                DropdownButton<String>(
                  value: tipPercentage,
                  isExpanded: true,
                  items: const [
                    DropdownMenuItem(
                      value: '10%',
                      child: Text('10%'),
                    ),
                    DropdownMenuItem(
                      value: '12%',
                      child: Text('12%'),
                    ),
                    DropdownMenuItem(
                      value: '15%',
                      child: Text('15%'),
                    ),
                  ],
                  onChanged: (value) {
                    if (value == null) return;
                    setState(() {
                      tipPercentage = value;
                    });
                  },
                ),

              const SizedBox(height: 16),

              if (tablesCount > 0)
                ElevatedButton(
                  onPressed: calculateTips,
                  child: const Text('Calcular Propinas'),
                ),

              const SizedBox(height: 16),
              Text(resultText),
            ],
          ),
        ),
      ),
    );
  }
}
