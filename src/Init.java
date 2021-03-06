import java.awt.*;

public class Init{

    //size window size
    public static int weight_w = 500; //standart 500
    public static int height_w = 500; //standart 500

    //size one of square
    public static int size_sqr = 50;
    
    //window set
    public static int weight_indent = 800;
    public static int height_indent = 400;
    
    //field
    public static int weight_size; 
    public static int height_size;

    //time
    public static int time = 150; //standart 150
    public static int debug = 0;

    //COLOR
    public static Color color_head = Color.BLACK;
    public static Color color_tail = Color.GRAY;
    public static Color color_food = Color.PINK;

    Init(){
        height_size = weight_w / size_sqr;
        weight_size = height_w / size_sqr;

        height_w += 20;
    }

    public static boolean is_true(){
        boolean flag = weight_w % size_sqr == 0 && (height_w - 20) % size_sqr == 0;
        if (!flag){
            System.out.println("Incorrect size of window");
        }
        return flag;
    }

    /*
        HEIGHT - X
        WEIGHT - Y
    */
}
