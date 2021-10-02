
package flappybirdclone;

import javax.swing.JFrame;


public class FlappyBirdClone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game flappyClone = new Game();
        flappyClone.setVisible(true);
        flappyClone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
