import java.util.Objects;

public class SnakeSection {
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeSection that = (SnakeSection) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}