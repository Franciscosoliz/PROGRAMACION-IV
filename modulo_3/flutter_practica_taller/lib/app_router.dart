import 'package:go_router/go_router.dart';
import 'pages/workshop_home_page.dart';
import 'pages/labor_page.dart';
import 'pages/parts_page.dart';
import 'pages/service_package_page.dart';
import 'pages/alignment_balance_page.dart';
import 'pages/quick_diagnosis_page.dart';

final appRouter = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => const WorkshopHomePage(),
    ),
    GoRoute(
      path: '/labor',
      builder: (context, state) => const LaborPage(),
    ),
    GoRoute(
      path: '/parts',
      builder: (context, state) => const PartsPage(),
    ),
    GoRoute(
      path: '/service',
      builder: (context, state) => const ServicePackagePage(),
    ),

    // NUEVAS PESTAÑAS
    GoRoute(
      path: '/alignment-balance',
      builder: (context, state) => AlignmentBalancePage(),
    ),
    GoRoute(
      path: '/quick-diagnosis',
      builder: (context, state) => QuickDiagnosisPage(),
    ),
  ],
);
