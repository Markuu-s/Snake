public class Snake {
    private int x_head;
    private int y_head;
    private int x_tail;
    private int y_tail;
    private int size;
    private boolean[][] snake;
    
    private int move_x;
    private int move_y;
    //if move_x != 0 then move_y == 0 and on the contrary

    Snake(){
        x_head = 0;
        y_head = 0;
        x_tail = 0;
        y_tail = 0;
        
        size = 1;
        snake = new boolean[Init.height_size][Init.weight_size];
        snake[0][0] = true;

        move_x = 1;
        move_y = 0;
    }

    public void run(){
        x_head += move_x;
        y_head += move_y;
        snake[x_head][y_head] = true;
    }

    public boolean[][] get_field(){
        return snake;
    }
}
