# TheMaze

A Java console maze-search example credited in the source to Cameron “Dumpy” Basham. It reads an integer grid from `RawMaze.txt`, explores neighboring cells and prints progress/status messages. It is not an interactive game or a shortest-path visualizer.

## Source and behavior

- `The_Maze/src/Main/MazeSolver.java` — main entrypoint: **`Main.MazeSolver`**; stack-based exploration of alternative cells, checking north, south, east and west.
- `MazeReader.java` — reads the grid and start/finish coordinates.
- `Position.java` — coordinate, bounds and blocked-cell checks.
- `FileReader.java` — separate **`Main.FileReader`** entrypoint that only reads the input; it does not invoke the solver.
- `The_Maze/doc/` — existing generated Java documentation. Tracked `.class` files under `The_Maze/bin/` and `out/` are not evidence of a current successful build.

The stack stores alternatives to explore, not a complete route for export. The code prints visited positions and completion/failure messages; no GUI, path visualization or saved result file is implemented.

## Input format

`RawMaze.txt` is read from the process's **working directory**, so launch from the repository root. Its whitespace-separated integers are:

1. `width height`
2. `width × height` cell values, consumed with the first array index iterating over `width`
3. Start coordinates: `x y`
4. Finish coordinates: `x y`

Coordinates are zero-based. Cell value `1` is blocked; other values are not treated as walls. The supplied example is square. **Rectangular inputs are unsafe as currently implemented:** grid allocation uses `[width][height]`, while bounds/visited logic uses the opposite dimension convention.

## Requirements and source-checked usage

Use a JDK with `javac` and `java`. IntelliJ metadata selects **JDK 21**, which is an IDE setting rather than a tested minimum; use a maintained JDK distribution. No third-party libraries, Maven build or Gradle build are declared.

These PowerShell commands are **unexecuted instructions**, from the repository root. A separate output folder avoids overwriting the tracked compiled files:

```powershell
New-Item -ItemType Directory -Force -Path .readme-build | Out-Null
$sources = (Get-ChildItem The_Maze/src/Main -Filter *.java).FullName
javac -d .readme-build $sources
```

Only after successful compilation:

```powershell
java -cp .readme-build Main.MazeSolver
```

Compilation writes class files; launching runs the solver against the fixed filename. Do not commit the temporary output folder. No command-line filename selector is implemented.

## Limitations

- The neighbor-selection switch handles zero through three candidates, but not four; a four-way eligible junction can repeatedly print an error without advancing.
- Rectangular dimensions and malformed/out-of-range input are not robustly handled.
- No shortest-path guarantee, automated test suite or verified run result is provided. Review the source before relying on it for arbitrary mazes.
