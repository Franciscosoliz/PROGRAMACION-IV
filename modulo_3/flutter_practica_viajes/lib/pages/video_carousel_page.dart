import 'package:flutter/material.dart';
import 'package:video_player/video_player.dart';

class VideoCarouselPage extends StatefulWidget {
  const VideoCarouselPage({super.key});

  @override
  State<VideoCarouselPage> createState() => _VideoCarouselPageState();
}

class _VideoCarouselPageState extends State<VideoCarouselPage> {
  final List<String> videos = [
    'assets/videos/video1.mp4',
    'assets/videos/video2.mp4',
  ];

  late PageController pageController;
  late List<VideoPlayerController> controllers;

  @override
  void initState() {
    super.initState();

    pageController = PageController();
    controllers = videos.map((v) => VideoPlayerController.asset(v)..initialize()).toList();
  }

  @override
  void dispose() {
    for (var c in controllers) {
      c.dispose();
    }
    pageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Carrusel de Videos')),
      body: PageView.builder(
        controller: pageController,
        itemCount: controllers.length,
        itemBuilder: (_, index) {
          final video = controllers[index];

          return video.value.isInitialized
              ? AspectRatio(
                  aspectRatio: video.value.aspectRatio,
                  child: VideoPlayer(video),
                )
              : const Center(child: CircularProgressIndicator());
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          final currentVideo = controllers[pageController.page!.round()];
          currentVideo.value.isPlaying ? currentVideo.pause() : currentVideo.play();
        },
        child: const Icon(Icons.play_arrow),
      ),
    );
  }
}
