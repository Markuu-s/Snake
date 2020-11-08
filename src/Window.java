import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class Window extends JFrame{
    private int weight, height;
    private boolean open;
    private boolean game;
    private boolean win;

    Window(int weight, int height){
        super("Snake");
        open = true;
        this.weight = weight;
        this.height = height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(Init.weight_indent, Init.height_indent,
         Init.weight_w, Init.height_w);
        setVisible(true);
        
        this.addKeyListener((KeyListener)new Key_adapter());
    }

    public boolean game(){
        return game;
    }

    public boolean is_it_win(){
        return win;
    }

    public void play_again(){
        game = true;
    }

    public boolean open(){
        return open;
    }

    public void fail(){
        game = false;
        getContentPane().removeAll();
        setVisible(true);
    }

    public void window_win(){
        JLabel jl = new JLabel("You win!!!");
        Font font = new Font("Veranda", Font.PLAIN, 64);
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setForeground(Color.BLACK);
        jl.setFont(font);

        getContentPane().add(jl);
        setVisible(true);
    }

    public void win(){
        System.out.println("Void win()");
        getContentPane().removeAll();
        game = false;
        win = true;
    }

    public void draw(Snake s){
        //FOOD
        if (Food.food){
            if (Food.image_food != null){
                getContentPane().remove(Food.image_food);
            }

            Food.food = false;
            Food.image_food = new Rectangle(
                Food.x * Init.size_sqr, 
                Food.y * Init.size_sqr, 
                Init.color_food);

            getContentPane().add(
                Food.image_food
            );
        } else{
            //TAIL
            getContentPane().remove(Snake.snake_image.poll());
        }
        setVisible(true);

        if (Snake.snake_image.size() >= 1){
            Rectangle pred_head = Snake.snake_image.pollLast();
            getContentPane().remove(pred_head);
            pred_head.change_color(Init.color_tail);
            setVisible(true);

            Snake.snake_image.addLast(pred_head);
            getContentPane().add(Snake.snake_image.getLast());
            setVisible(true);
        }

        //HEAD
        Snake.snake_image.addLast(new Rectangle(
            Snake.x_head * Init.size_sqr,
            Snake.y_head * Init.size_sqr, 
            Init.color_head));

        getContentPane().add(
            Snake.snake_image.getLast()
        );
        setVisible(true);

    }
}
