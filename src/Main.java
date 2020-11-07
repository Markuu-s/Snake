import java.util.Scanner;
//1. BLock button, which directs in the opposite direction from the movement
//2. Add more comment
//3. Make smooth movement
//4. Add win label
//5. Add "Play again?"
//6. Sometimes lost food for snake
public class Main {
    public static void main(String[] argc) throws InterruptedException {
        new Init();
        if (!Init.is_true()){
            return;
        }
        Window g = new Window(Init.weight_w, Init.height_w);
        Snake s = new Snake();
        new Food(s);

        while(g.open()){
            Thread.sleep(Init.time);
            g.draw(s);
            s.run(g);
        }
        g.win();
        Scanner in = new Scanner(System.in);
        in.next();
    }
}
