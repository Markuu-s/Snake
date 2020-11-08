import javax.swing.*;
import java.awt.*;

class Rectangle extends JComponent {
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

    public void change_color(Color new_){
        c = new_;
    }
}