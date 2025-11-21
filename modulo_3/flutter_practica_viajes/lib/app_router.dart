import 'package:go_router/go_router.dart';

import 'pages/travel_home_page.dart';
import 'pages/photo_carousel_page.dart';
import 'pages/video_carousel_page.dart';

final GoRouter appRouter = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (_, __) => const TravelHomePage(),
    ),
    GoRoute(
      path: '/photos',
      builder: (_, __) => const PhotoCarouselPage(),
    ),
    GoRoute(
      path: '/videos',
      builder: (_, __) => const VideoCarouselPage(),
    ),
  ],
);
