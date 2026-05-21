
public class Cell {

    private final int row;
    private final int col;
    private boolean visited = false;
    private final boolean[] sides = new boolean[4];

    public Cell(int nRow, int nCol) {
        row = nRow;
        col = nCol;

        sides[0] = false; // UP
        sides[1] = false; // DOWN
        sides[2] = false; // LEFT
        sides[3] = false; // RIGHT
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        visited = true;
    }

    public boolean isOpen(Side side) {
        if (null != side) switch (side) {
            case Side.UP:
                return sides[0];
            case Side.DOWN:
                return sides[1];
            case Side.LEFT:
                return sides[2];
            case Side.RIGHT:
                return sides[3];
            default:
        }

        return false;
    }

    public void openSide(Side side) {
        if (null != side) switch (side) {
            case Side.UP:
                sides[0] = true;
                break;
            case Side.DOWN:
                sides[1] = true;
                break;
            case Side.LEFT:
                sides[2] = true;
                break;
            case Side.RIGHT:
                sides[3] = true;
                break;
            default:
        }
    }
}