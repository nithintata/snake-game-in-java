public class Room {
    public static Room game;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.height = height;
        this.width = width;
        this.snake = snake;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(5, 20);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(200, 200, snake);
        game.createMouse();
        game.run();
    }

    public void createMouse() {
        this.mouse =  new Mouse((int) (Math.random() * width), (int) (Math.random() * height));
    }

    public  void  eatMouse() {
        createMouse();;
    }

    public void run() {
        print();
    }

    public void print() {
        int [][] matrix = new int[height][width];
        for (SnakeSection s : snake.getSections()) {
            matrix[s.getY()][s.getX()] = 1;
        }
        matrix[snake.getY()][snake.getX()] = 2;
        matrix[mouse.getY()][mouse.getX()] = 3;
        StringBuilder sb = new StringBuilder();
        for (int[] i : matrix) {
            for (int j : i) {
                if(j == 1)
                    sb.append("x");
                else if(j == 2)
                    sb.append("X");
                else if(j == 3)
                    sb.append("^");
                else
                    sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public  void sleep() throws InterruptedException {
        int pause = getSnake().getSections().size();
        if (pause == 1)
            Thread.sleep(500);
        else if (pause < 11)
            Thread.sleep(500 - (20 * pause - 20));
        else if (pause < 15)
            Thread.sleep(500 - (20 * pause - 20));
        else
            Thread.sleep(200);
    }
}