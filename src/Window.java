import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class Window extends JFrame{
    private int weight, height;
    private boolean open;

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
        setVisible(false);
        dispose();
    }

    public void win(){
        getContentPane().removeAll();
    }

    public void draw(Snake s){
        getContentPane().removeAll();
        boolean[][] snake = s.get_field();
        for(int x = 0; x < Init.height_size; ++x){
            for(int y = 0; y < Init.weight_size; ++y){
                if (snake[x][y]){
                    int[] temp = {x, y};
                    if (Arrays.equals(s.get_head(), temp)){
                        getContentPane().add(
                        new Rectangle(x * Init.size_sqr, y * Init.size_sqr,
                         Color.DARK_GRAY));    
                    }
                    else{
                        getContentPane().add(
                            new Rectangle(x * Init.size_sqr, y * Init.size_sqr,
                            Color.BLACK));
                    }
                }

                if (x == Food.x && y == Food.y){
                    getContentPane().add(
                        new Rectangle(x * Init.size_sqr, y * Init.size_sqr, 
                        Color.PINK)
                    );
                }
                setVisible(true);
            }
        }
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