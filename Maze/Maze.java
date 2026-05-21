import java.awt.Color;
import java.util.*;

public class Maze {

    private final int nRows;
    private final int nCols;
    private final Cell[][] cells;
    private final Color backgroundColor = Color.WHITE;
    private final Color visitedColor    = Color.LIGHT_GRAY;
    private final Color currentColor    = Color.GREEN;
    private final Color wallColor       = Color.BLACK;
    private final Color openColor   = Color.YELLOW;
    private final Color closedColor = new Color(173, 216, 230); // light blue
    private final Color pathColor   = new Color(255, 100, 100); // red-pink

    public Maze(int rows, int cols) {
        nRows = rows;
        nCols = cols;
        cells = new Cell[nRows][nCols];

        for (int row = 0; row < nRows; row++)
            for (int col = 0; col < nCols; col++)
                cells[row][col] = new Cell(row, col);

        generateMaze();
    }

    private void generateMaze() {
        Stack<Cell> stack = new Stack<>();
        Cell current = cells[0][0];
        current.visit();
        stack.push(current);

        while (!stack.isEmpty()) {
            Cell next = getUnvisitedNeighbor(current);
            if (next != null) {
                next.visit();
                connect(current, next);
                stack.push(next);
                current = next;
            } else {
                current = stack.pop();
            }

            show(current);
            sleep(50);
        }
    }

    private Cell getUnvisitedNeighbor(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        ArrayList<Cell> neighbors = new ArrayList<>();

        if (row > 0         && !cells[row - 1][col].isVisited()) neighbors.add(cells[row - 1][col]);
        if (row < nRows - 1 && !cells[row + 1][col].isVisited()) neighbors.add(cells[row + 1][col]);
        if (col > 0         && !cells[row][col - 1].isVisited()) neighbors.add(cells[row][col - 1]);
        if (col < nCols - 1 && !cells[row][col + 1].isVisited()) neighbors.add(cells[row][col + 1]);

        if (neighbors.isEmpty()) return null;
        return neighbors.get((int) (Math.random() * neighbors.size()));
    }

    private void connect(Cell a, Cell b) {
        if (a.getRow() == b.getRow()) {
            if (a.getCol() < b.getCol()) { a.openSide(Side.RIGHT); b.openSide(Side.LEFT);  }
            else                         { a.openSide(Side.LEFT);  b.openSide(Side.RIGHT); }
        } else {
            if (a.getRow() < b.getRow()) { a.openSide(Side.DOWN); b.openSide(Side.UP);   }
            else                         { a.openSide(Side.UP);   b.openSide(Side.DOWN); }
        }
    }

    private void draw() {
        StdDraw.clear(backgroundColor);
        StdDraw.setPenColor(wallColor);
        StdDraw.setPenRadius(0.005);

        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                Cell cell = cells[row][col];
                double x = col + 0.5;
                double y = nRows - row - 0.5;

                StdDraw.setPenColor(cell.isVisited() ? visitedColor : backgroundColor);
                StdDraw.filledSquare(x, y, 0.5);

                StdDraw.setPenColor(wallColor);
                if (!cell.isOpen(Side.UP))    StdDraw.line(x - 0.5, y + 0.5, x + 0.5, y + 0.5);
                if (!cell.isOpen(Side.DOWN))  StdDraw.line(x - 0.5, y - 0.5, x + 0.5, y - 0.5);
                if (!cell.isOpen(Side.LEFT))  StdDraw.line(x - 0.5, y - 0.5, x - 0.5, y + 0.5);
                if (!cell.isOpen(Side.RIGHT)) StdDraw.line(x + 0.5, y - 0.5, x + 0.5, y + 0.5);
            }
        }
    }

    public void show() {
        draw();
        StdDraw.show(); 
    }

    public void show(Cell current) {
        draw();

        double x = current.getCol() + 0.5;
        double y = nRows - current.getRow() - 0.5;
        StdDraw.setPenColor(currentColor);
        StdDraw.filledSquare(x, y, 0.5);

        StdDraw.show(); 
    }


    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) { }
    }

    public void solve() {
        Cell start = cells[0][0];
        Cell goal  = cells[nRows - 1][nCols - 1];

        // g: actual cost from start; f: g + heuristic
        Map<Cell, Integer> gScore = new HashMap<>();
        Map<Cell, Integer> fScore = new HashMap<>();
        Map<Cell, Cell>    cameFrom = new HashMap<>();
        Set<Cell>          openSet  = new HashSet<>();
        Set<Cell>          closedSet = new HashSet<>();

        gScore.put(start, 0);
        fScore.put(start, heuristic(start, goal));
        openSet.add(start);

        PriorityQueue<Cell> frontier = new PriorityQueue<>(
            Comparator.comparingInt(c -> fScore.getOrDefault(c, Integer.MAX_VALUE))
        );
        frontier.add(start);

        while (!frontier.isEmpty()) {
            Cell current = frontier.poll();

            if (current == goal) {
                reconstructPath(cameFrom, current);
                return;
            }

            openSet.remove(current);
            closedSet.add(current);

            for (Cell neighbor : getOpenNeighbors(current)) {
                if (closedSet.contains(neighbor)) continue;

                int tentativeG = gScore.getOrDefault(current, Integer.MAX_VALUE) + 1;

                if (tentativeG < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeG);
                    fScore.put(neighbor, tentativeG + heuristic(neighbor, goal));

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                        frontier.add(neighbor);
                    }
                }
            }

            drawSolve(openSet, closedSet, current);
            sleep(20);
        }
    }

    private int heuristic(Cell a, Cell b) {
        return Math.abs(a.getRow() - b.getRow()) + Math.abs(a.getCol() - b.getCol());
    }

    private List<Cell> getOpenNeighbors(Cell cell) {
        List<Cell> result = new ArrayList<>();
        int row = cell.getRow();
        int col = cell.getCol();

        if (cell.isOpen(Side.UP)    && row > 0)         result.add(cells[row - 1][col]);
        if (cell.isOpen(Side.DOWN)  && row < nRows - 1) result.add(cells[row + 1][col]);
        if (cell.isOpen(Side.LEFT)  && col > 0)         result.add(cells[row][col - 1]);
        if (cell.isOpen(Side.RIGHT) && col < nCols - 1) result.add(cells[row][col + 1]);

        return result;
    }

    private void reconstructPath(Map<Cell, Cell> cameFrom, Cell current) {
        List<Cell> path = new ArrayList<>();
        while (cameFrom.containsKey(current)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(current);

        for (int i = path.size() - 1; i >= 0; i--) {
            Cell cell = path.get(i);
            double x = cell.getCol() + 0.5;
            double y = nRows - cell.getRow() - 0.5;
            StdDraw.setPenColor(pathColor);
            StdDraw.filledSquare(x, y, 0.4);
            StdDraw.show();
            sleep(30);
        }
    }

    private void drawSolve(Set<Cell> openSet, Set<Cell> closedSet, Cell current) {
        draw(); 

        for (Cell c : closedSet) {
            double x = c.getCol() + 0.5;
            double y = nRows - c.getRow() - 0.5;
            StdDraw.setPenColor(closedColor);
            StdDraw.filledSquare(x, y, 0.5);
        }
        for (Cell c : openSet) {
            double x = c.getCol() + 0.5;
            double y = nRows - c.getRow() - 0.5;
            StdDraw.setPenColor(openColor);
            StdDraw.filledSquare(x, y, 0.5);
        }

        double x = current.getCol() + 0.5;
        double y = nRows - current.getRow() - 0.5;
        StdDraw.setPenColor(currentColor);
        StdDraw.filledSquare(x, y, 0.5);

        StdDraw.setPenColor(wallColor);
        StdDraw.setPenRadius(0.001);
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                Cell cell = cells[row][col];
                double cx = col + 0.5;
                double cy = nRows - row - 0.5;
                if (!cell.isOpen(Side.UP))    StdDraw.line(cx-0.5, cy+0.5, cx+0.5, cy+0.5);
                if (!cell.isOpen(Side.DOWN))  StdDraw.line(cx-0.5, cy-0.5, cx+0.5, cy-0.5);
                if (!cell.isOpen(Side.LEFT))  StdDraw.line(cx-0.5, cy-0.5, cx-0.5, cy+0.5);
                if (!cell.isOpen(Side.RIGHT)) StdDraw.line(cx+0.5, cy-0.5, cx+0.5, cy+0.5);
            }
        }

        StdDraw.show();
    }

    public static void main(String[] args) {
        int size = 20;

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(650, 650);
        StdDraw.setXscale(0, size);
        StdDraw.setYscale(0, size);

        Maze maze = new Maze(size, size);
        maze.show();
        System.out.print("Press enter to solve...");
        StdIn.readFloat();
        maze.solve();
    }
}