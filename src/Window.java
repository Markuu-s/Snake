import javax.swing.*;
import java.awt.*;

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
        
    }

    public boolean open(){
        return open;
    }

    public void close(){
        setVisible(false);
        dispose();
    }

    public void draw(Snake s){
        getContentPane().removeAll();
        boolean[][] snake = s.get_field();
        for(int x = 0; x < Init.height_size; ++x){
            for(int y = 0; y < Init.weight_size; ++y){
                if (snake[x][y]){
                    getContentPane().add(
                        new Rectangle(x * Init.size_sqr, y * Init.size_sqr, Color.BLACK));
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