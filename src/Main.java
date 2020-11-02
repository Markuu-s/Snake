public class Main {
    public static void main(String[] argc){
        new Init();
        if (!Init.is_true()){
            return;
        }
        Window g = new Window(Init.weight_w, Init.height_w);
        Snake s = new Snake();

        while(g.open()){
            s.run();
            g.draw(s);
        }
    }
}
