package flappybirdclone;

import java.awt.Toolkit;
import java.net.URL;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author ppesq
 */
public class Pipes extends Base implements Constants {

    //variables
    private ImageIcon pipeUp;
    private ImageIcon pipeDown;
    private int gap;
    private boolean passed;
    //private int xPipeUp;
    //private int xPipeDown;
    //private int yPipeUp;
    //private int yPipeDown;

    public Pipes(int xParam, int yParam) {
        super(xParam, yParam);
        int x = WINDOW_WIDTH;
        int y = (-1)*((int)(Math.random()*218) + 125);
        this.setPosX(this.getPosX() + x);
        this.setPosY(y);
        setPassed(false);
        pipeUp = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(IMG_UPPERGREENPIPE)));
        pipeDown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(IMG_LOWERGREENPIPE)));
    }

    public Image getPipeUp() {
        return pipeUp.getImage();
    }

    public Image getPipeDown() {
        return pipeDown.getImage();
    }

    public boolean checkPipeCollision(Base obj) {
        return (checkPipeUpCollision(obj) || checkPipeDownCollision(obj) );
    }

    public Rectangle getPerimetro(int x, int y) {
        return new Rectangle(x, y, PIPE_WIDTH, PIPE_HEIGHT);
    }

    public boolean intersect(int x, int y, Base obj) {
        return getPerimetro(x, y).intersects(obj.getPerimetro(BIRD_WIDTH, BIRD_HEIGHT));
    }

    public boolean checkPipeUpCollision(Base obj) {
        return intersect(getPosX(), getPosY(), obj);
    }

    public boolean checkPipeDownCollision(Base obj) {
        return intersect(getPosX(), getPosY() + getGap(), obj);
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    
    public void move() {
        //It's only necessary to move the pipe on x
        //The Y position stays always the same

        this.setPosX(this.getPosX() - GAME_SPEED);
    }
    
    /**
     * Method resetThisPipe that resets the position 
     * of the pipes given the last pipe on the game list
     * @param lastPipe last pipe drawn on the game, where I want to 
     * append this reseted pipe of type <code>Pipes</code>
     */
    public void resetThisPipe(Pipes lastPipe, int newPositionX){
        this.setPosX(newPositionX - PIPE_WIDTH);
        setPassed(false); 
    }

}
