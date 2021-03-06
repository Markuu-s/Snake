import java.util.Deque;
import java.util.LinkedList;

public class Snake {
    public static int x_head;
    public static int y_head;
    
    private int x_tail;
    private int y_tail;
    
    public static Deque<Rectangle> snake_image;
    //this for draw and correct treatment movent of tail
    
    public static int size; //size_max == Init.height_size * Init.weight_size
    private boolean[][] snake;
    //if true -> on this element the snake

    private int[][] move_by_x;
    private int[][] move_by_y;
    //to each cell where the snake is located, remember its direction to move the snake
    //this is necessary for the snake to move its tail

    public static int move_x;
    public static int move_y;
    //if move_x != 0 then move_y == 0 and on the contrary

    public static int pred_move_x;
    public static int pred_move_y;
    //this for draw

    Snake(){
        snake_image = new LinkedList<Rectangle>();
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

        pred_move_x = 0;
        pred_move_y = 0;
    }

    public void run(Window g){
        pred_move_x = move_x;
        pred_move_y = move_y;
        move_by_x[x_head][y_head] = move_x;
        move_by_y[x_head][y_head] = move_y;
        
        x_head += move_x;
        y_head += move_y;
        
        x_head = check(x_head, Init.height_size);
        y_head = check(y_head, Init.weight_size);

        if (snake[x_head][y_head]){
            System.out.println("You lose :(");
            g.fail();
            return;
        }

        boolean flag = true;
        snake[x_head][y_head] = true; 
        if (x_head == Food.x && y_head == Food.y){
            flag = false;
            ++size;
            if (size == Init.height_size * Init.weight_size){
                //if snake takes all field
                g.win();
                return;
            }
            Food.random(this);
        }

        if (flag){ //If snake hasnot a meal
            snake[x_tail][y_tail] = false;

            int temp_x_tail = x_tail;
            x_tail = move_by_x[x_tail][y_tail] + x_tail;
            y_tail = move_by_y[temp_x_tail][y_tail] + y_tail;

            x_tail = check(x_tail, Init.height_size);
            y_tail = check(y_tail, Init.weight_size);
        }else{
            System.out.println("Snake has a meal");
        }

    }
    //1. Move head
    //2. For graphics(array of snake) draw new head and delete old tail
    //3. Move tail

    private int check(int x, int In_size){ //check field boundaries
        if (x == In_size){ 
            x = 0;
        }
        if (x == -1){
            x = In_size - 1;
        }
        return x;
    }

    public boolean[][] get_field(){//just function for comfort
        return snake;
    }
}
