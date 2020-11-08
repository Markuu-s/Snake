import java.util.Scanner;

//1. Add more comment
//4. Когда змея в один ряд/строку и имеет размер строки или ряда она
// не должна умирать
public class Main {
    public static void main(String[] argc) throws InterruptedException {
        new Init();
        if (!Init.is_true()){
            return;
        }
        Window g = new Window(Init.weight_w, Init.height_w);
        
        while (g.open()){
            g.play_again();

            //reset snake and field
            Snake s = new Snake();
            new Food(s);
            
            while(g.game()){
                g.draw(s);
                Thread.sleep(Init.time);
                s.run(g);
            }

            if (g.is_it_win()){
                g.window_win();
                break;
            } else{

            }
        }        
    }
}
