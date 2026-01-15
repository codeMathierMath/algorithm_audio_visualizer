# Algorithm Audio-Visualizer

This repository contains an educational framework for exploring
algorithms through synchronized visual and auditory feedback.

The core idea of audio-visual algorithm representation was introduced
as part of coursework. The implementation, organization, and planned
extensions reflect independent student work.

---

## Overview

Algorithms are often taught visually, but their dynamic behavior can
also be explored through sound. In this project, algorithmic state is
represented using simple graphical elements paired with generated
audio signals, allowing changes in ordering to be perceived both
visually and aurally.

Each data element:
- stores a numeric value
- generates an audio waveform derived from that value
- draws itself as a visual bar in a shared canvas

---

## Structure

```
src/
├── core/
│ └── Element.java
├── algorithms/
│ ├── InsertionSort.java
│ └── MergeSort.java
└── visualizer/
   └── (future shared visualization helpers)
```


- `Element` defines the shared data, audio, and drawing representation.
- Each algorithm class contains its own `main` method and drives the
  visualization independently.
- The structure is designed to support adding additional algorithms.

---

## Implemented Algorithms

- **Insertion Sort** — comparison-based sorting with local swaps
- **Merge Sort** — recursive divide-and-conquer sorting with merging

Each algorithm visualizes comparisons and movements using color and
sound to emphasize structure and progression.

---

## Concepts Demonstrated

- Algorithm visualization
- Audio signal synthesis
- Recursive and iterative control flow
- Mapping abstract state to perceptual output
- Separation of data representation and algorithm logic

The focus is on clarity and perceptual insight rather than performance
or completeness.

---

## Notes on Attribution

The concept of audio-visual algorithm exploration was introduced in
coursework. This repository reflects the student implementation and
serves as a foundation for further independent experimentation.

---

## Running

This project is written in Java and is intended to be run from the command line.

From the project root directory, compile all source files (including dependencies):

```bash
javac *.java lib/*.java

## Dependencies

This project uses Princeton's introductory libraries for visualization and audio:

- **StdDraw** — 2D graphics rendering
- **StdAudio** — real-time audio playback

These files are included locally in the `lib/` directory for convenience.

## Future Improvements

- Add additional algorithms (e.g. selection sort, quicksort)
- Refactor storage to use Java Collections
- Parameterize audio mappings (frequency, duration, waveform)
- Improve visualization scaling and timing
- Introduce interactive controls (pause, step, reset)

