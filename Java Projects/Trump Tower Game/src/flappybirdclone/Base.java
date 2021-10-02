package flappybirdclone;


import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * This is the base class for the player icon
 * 
 */
public class Base implements Constants {

    //Motion control
    private int posX;    //position x.       
    private int posY;	//position y.
    
    //animation control
    private Animation animation;

    /* CONSTRUCTORS */
    /**
     * Default Constructor
     * Initializes the players position
     *
     */
    public Base() {
        this.posX = 0;
        this.posY = 0;
    }
    
    /**
     * Parameterized Constructor 
     * Sets players position to the accepted coordinates
     */
    public Base(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    /**
     * Access method for the position in X
     * @return returns posX of type integer
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets the X position of icon
     * @ param posX is the position of icon
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    /**
     * Returns the Y position of icon
     * @return returns the Y position of icon
     */
    public int getPosY() {
        return posY;
    }
    
    /**
     * Sets the Y position of icon
     * @param posX of type <code>int</code>
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    /**
    * 
	* Returns the width of the icon
    * @return returns the width of the icon
    */
   public int getWidth() {
           //return icono.getIconWidth();
           return (new ImageIcon(animation.getImagen())).getIconWidth();
   }

   /**
    * Returns the height of the icon
    * @return returns height of the icon
    */
   public int getHeight() {
           //return icono.getIconHeight();
       return (new ImageIcon(animation.getImagen())).getIconHeight();
   }

   public Rectangle getPerimetro(int ancho, int alto){
            return new Rectangle(getPosX(), getPosY(), ancho, alto);
    }
}
