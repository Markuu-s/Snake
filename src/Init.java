public class Init {

    //size window size
    public static int weight_w = 500;
    public static int height_w = 500;

    //size one of square
    public static int size_sqr = 50;
    
    //window set
    public static int weight_indent = 800;
    public static int height_indent = 400;
    
    //field
    public static int weight_size; 
    public static int height_size;

    public static int time = 500;

    Init(){
        weight_size = weight_w / size_sqr;
        height_size = height_w / size_sqr;
    }

    public static boolean is_true(){
        return weight_w % size_sqr == 0 && height_w % size_sqr == 0;
    }
}
