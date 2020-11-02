import java.util.Scanner;

public class Main {
    public static void main(String[] argc){
        Window g = new Window(500, 500);
        while(g.open()){
            Scanner in = new Scanner(System.in);
            in.nextLine();
            g.close();
        }
    }
}
