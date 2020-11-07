//2. Add more comment
//4. Add win label
//5. Add "Play again?"
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
            g.draw(s);
            Thread.sleep(Init.time);
            s.run(g);
        }
    }
}
