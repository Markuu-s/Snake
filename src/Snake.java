public class Snake {
    private int x_head;
    private int y_head;
    
    private int x_tail;
    private int y_tail;
    
    private int size;
    private boolean[][] snake;

    private int[][] move_by_x;
    private int[][] move_by_y;

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

        move_by_x = new int[Init.height_size][Init.weight_size];
        move_by_y = new int[Init.height_size][Init.weight_size];

        move_x = 1;
        move_y = 0;
    }

    public void run(){
        move_by_x[x_head][y_head] = move_x;
        move_by_y[x_head][y_head] = move_y;
        
        x_head += move_x;
        y_head += move_y;
        
        x_head = check_x(x_head);
        y_head = check_y(y_head);

        snake[x_head][y_head] = true;
        snake[x_tail][y_tail] = false;

        int temp_x_tail = x_tail;
        x_tail = move_by_x[x_tail][y_tail] + x_tail;
        y_tail = move_by_y[temp_x_tail][y_tail] + y_tail;

        x_tail = check_x(x_tail);
        y_tail = check_y(y_tail);

    }

    private int check_x(int x){
        if (x == Init.height_size){
            x = 0;
        }
        if (x == -1){
            x = Init.height_size- 1;
        }
        return x;
    }

    private int check_y(int y){
        if (y == Init.weight_size){
            y = 0;
        }
        if (y == -1){
            y = Init.weight_size - 1;
        }
        return y;
    }

    public boolean[][] get_field(){
        return snake;
    }
}
