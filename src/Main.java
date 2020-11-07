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
        
    }
}
