import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class Window extends JFrame{
    private int weight, height;
    public boolean open;

    Window(int weight, int height){
        super();
        open = true;
        this.weight = weight;
        this.height = height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(Init.weight_indent, Init.height_indent,
         Init.weight_w, Init.height_w);
        setVisible(true);
        
        this.addKeyListener((KeyListener)new Key_adapter());
    }

    public boolean open(){
        return open;
    }

    public void close(){
        open = false;
        getContentPane().removeAll();
        setVisible(true);
    }

    public void win(){
        System.out.println("Void win()");
        getContentPane().removeAll();
    }

    public void draw(Snake s){
        if (Food.food){
            if (Food.image_food != null){
                getContentPane().remove(Food.image_food);
            }

            Food.food = false;
            Food.image_food = new Rectangle(
                Food.x * Init.size_sqr, 
                Food.y * Init.size_sqr, 
                Color.PINK);

            getContentPane().add(
                Food.image_food
            );
        } else{
            getContentPane().remove(Snake.snake_image.poll());
        }
        setVisible(true);

        Snake.snake_image.addLast(new Rectangle(
            Snake.x_head * Init.size_sqr,
            Snake.y_head * Init.size_sqr, 
            Color.BLACK));

        getContentPane().add(
            Snake.snake_image.getLast()
        );
        setVisible(true);

    }
}

class Rectangle extends JComponent{
    private int weight;
    private int height;
    private Color c;
    
    Rectangle(int weight, int height, Color c){
        this.weight = weight;
        this.height = height;
        this.c = c;
    }

    public void paint(Graphics g){
        g.setColor(c);
        g.fillRect(weight, height, Init.size_sqr, Init.size_sqr);
    }
}