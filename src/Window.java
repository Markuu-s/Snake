import javax.swing.*;
import java.awt.*;

class Window extends JWindow{
    private int weight, height;

    Window(int weight, int height){
        super();
        this.weight = weight;
        this.height = height;

        setLocation(200, 100);
        setSize(weight, height);

        setVisible(true);
    }

    public boolean open(){
        
        return true;
    }
}