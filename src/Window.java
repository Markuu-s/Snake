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
        setBounds(500, 500, weight, height);
        getContentPane().add(new Rectangle()); //??
        setVisible(true);
    }

    public boolean open(){
        return open;
    }

    public void close(){
        setVisible(false);
        dispose();
    }
}

class Rectangle extends JComponent{
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 10, 10);

    }
}