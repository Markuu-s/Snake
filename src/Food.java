public class Food {
    static int x;
    static int y;
    static boolean food;
    //Did the snake eat food
    static Rectangle image_food;

    Food(Snake a){
        random(a);
    }

    static void random(Snake a){
        food = true;
        boolean[][] v = a.get_field();
        int cnt_free = 0;
        for(int i = 0; i < v.length; ++i){
            for(int j = 0; j < v[i].length; ++j){
                if (!v[i][j]){
                    ++cnt_free;
                }
            }
        }

        int[][] ran = new int[cnt_free][2];
        int k = 0;
        for(int i = 0; i < v.length; ++i){
            for(int j = 0; j < v[i].length; ++j){
                if (!v[i][j]){
                    ran[k][0] = i;
                    ran[k][1] = j;
                    ++k;
                }
            }
        }

        int idx = (int)(Math.random() * 1000000) % cnt_free;
        x = ran[idx][0];
        y = ran[idx][1];
    }
}
