//1. Add more comment
//2. Add win label
//3. Add "Play again?"
//4. Random food doesn`t work correct
//  sometimes food appears on snake
// snake[head] need do earluy than chek on food
public class Main {
    public static void main(String[] argc) throws InterruptedException {
        new Init();
        if (!Init.is_true()){
            return;
        }
        Window g = new Window(Init.weight_w, Init.height_w);

        while (true){
            g.open = true;
            Snake s = new Snake();
            new Food(s);
            
            while(g.open()){
                g.draw(s);
                Thread.sleep(Init.time);
                s.run(g);
            }
        }        
    }
}
