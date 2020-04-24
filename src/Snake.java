import java.util.ArrayList;
import java.util.List;

//import static Room.game;

public class Snake {
    private  List<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;
    private  SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        SnakeSection head = new SnakeSection(x, y);
        sections.add(head);
        isAlive = true;
    }

    public int getX() {
        return  sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public  void move() {
        if (isAlive()) {
            if (direction == SnakeDirection.UP)
                move(0, -1);
            else if (direction == SnakeDirection.RIGHT)
                move(1, 0);
            else if (direction == SnakeDirection.DOWN)
                move(0, 1);
            else if (direction == SnakeDirection.LEFT)
                move(-1, 0);
        }
    }
    public void move(int x, int y) {

        SnakeSection new_section = new SnakeSection(sections.get(0).getX()+x,sections.get(0).getY()+y);

        checkBorders(new_section);
        checkBody(new_section);

        if (isAlive) {

            if (new_section.getX() == Room.game.getMouse().getX() && new_section.getY() == Room.game.getMouse().getY()) {
                sections.add(0, new_section);
                Room.game.eatMouse();
            } else {
                sections.add(0, new_section);
                sections.remove(sections.size() - 1);
            }

        }
    }
    public void checkBorders(SnakeSection head) {
        if (head.getX() < 0 || head.getY() < 0 || head.getY() >= Room.game.getHeight() || head.getX() >= Room.game.getWidth())
            isAlive = false;
    }
    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) isAlive = false;
    }
}