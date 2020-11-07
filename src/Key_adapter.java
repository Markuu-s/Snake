import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key_adapter extends KeyAdapter{
    
    public void keyPressed(KeyEvent event){
        System.out.println("CLICK!" + Init.debug++);
        switch(event.getKeyCode()){
            case 37:{ // LEFT
                if (Snake.pred_move_x == 1 && Snake.size != 1){
                    break;
                }
                Snake.move_y = 0;
                Snake.move_x = -1;
                break;
            }

            case 38:{ //TOP
                if (Snake.pred_move_y == 1 && Snake.size != 1){
                    break;
                }
                Snake.move_x = 0;
                Snake.move_y = -1;
                break;
            }

            case 39:{ //RIGHT
                if (Snake.pred_move_x == -1 && Snake.size != 1){
                    break;
                }
                Snake.move_y = 0;
                Snake.move_x = 1;
                break;
            }

            case 40:{ //BOTTOM
                if (Snake.pred_move_y == -1 && Snake.size != 1){ 
                    break;
                }
                Snake.move_x = 0;
                Snake.move_y = 1;
                break;
            }
        }
    }
}
