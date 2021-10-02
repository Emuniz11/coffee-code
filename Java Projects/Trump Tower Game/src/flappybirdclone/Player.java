package flappybirdclone;

import java.awt.Image;


public class Player extends Base implements Constants {
    //movement
    private int ySpeed = 0; 

    //animations
    Animation basic; 
    
    public Player(int posX, int posY, Animation a1) {
        setPosX(posX);
        setPosY(posY);
        ySpeed = 0; 
        basic = a1; 
    }
    
    public void resetPosition() {
        setPosX(BIRD_DEFAULTX);
        setPosY(BIRD_DEFAULTY);
        setySpeed(0);
    }
    public void flap(){
        setySpeed(-30);
    }
    
    public void updateAnimation(long timeElapsed){
        basic.update(timeElapsed);
    }
    
    public void move(double timer){
        double newYSpeed = getySpeed() + timer * G;  
        setySpeed( (int)Math.round(newYSpeed) );
        setPosY((getPosY() + getySpeed()));
    }

    // Getters and Setters
    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public Image getImage(){
        return basic.getImagen(); 
    }
}
