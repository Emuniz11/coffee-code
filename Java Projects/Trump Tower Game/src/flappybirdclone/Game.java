package flappybirdclone;

/**
 *
 * @author ppesq
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.LinkedList;

/**
 * The AppletAnimation applet displays an on-screen animation.
 */
public class Game extends JFrame implements Constants, Runnable, KeyListener, MouseListener{

    private Image dbImage;    // image to be projected
    private Graphics gObj;	// graphic object
    private Image background;   //background image
    private LinkedList<Pipes> list;   //list for pipes
    private Pipes pipe;     // pipe objects

    private URL backgroundDay = this.getClass().getResource(IMG_BACKGROUNDDAY);
    private URL backgorundNight = this.getClass().getResource(IMG_BACKGROUNDNIGHT);

    //floor
    private ImageIcon floor; //floor image
    private URL floorURL = this.getClass().getResource(IMG_FLOOR);
    private int floorPos; //contains the x position of the floor

    //pause
    private ImageIcon pause; //pause image
    private ImageIcon play; //play image
    private URL pauseURL = this.getClass().getResource(IMG_PLAYBUTTON);
    private URL playURL = this.getClass().getResource(IMG_PAUSEBUTTON);
    private int playCounter; //counter of cycles the play image stays on after pressing space

    // Animation Time Control Variables
    private long currentTime;
    private long initialTime;
    private double timer;

    boolean slowDown;
    boolean crashed;
    boolean gameOverAnimation;
    boolean scored; //to control the reproduction of soundClip when earning points
    private int score;

    //characters
    private Player playerIcon;

    //Bird URLs
    private URL greenBird1 = this.getClass().getResource(IMG_GREENBIRDMID);
    private URL greenBird2 = this.getClass().getResource(IMG_GREENBIRDHIGH);
    private URL greenBird3 = this.getClass().getResource(IMG_GREENBIRDLOW);
    private URL blueBird1 = this.getClass().getResource(IMG_BLUEBIRDMID);
    private URL blueBird2 = this.getClass().getResource(IMG_BLUEBIRDHIGH);
    private URL blueBird3 = this.getClass().getResource(IMG_BLUEBIRDLOW);

    //Sound
    SoundClip jumpClip;
    SoundClip gameOverClip;
    SoundClip scoreClip;


    /**
     * Constructor from the Game class that calls init and start methods.
     */
    public Game() {
        init();
        start();
    }

    public void init() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        resetPipes();
        
        
        slowDown = true;
        crashed = false;
        gameOverAnimation = false;
        scored = false;
        floorPos = 0;
        playCounter = 0;
        
        //sound effects
        jumpClip = new SoundClip(SND_FLAP);
        gameOverClip = new SoundClip(SND_FAIL);
        scoreClip = new SoundClip(SND_POINT);

        // create bird on screen default pos
        playerIcon = createBird(BIRD_DEFAULTX, BIRD_DEFAULTY);
        
        background = Toolkit.getDefaultToolkit().getImage(backgroundDay);
        floor = new ImageIcon(Toolkit.getDefaultToolkit().getImage(floorURL));
        pause = new ImageIcon(Toolkit.getDefaultToolkit().getImage(pauseURL));
        play = new ImageIcon(Toolkit.getDefaultToolkit().getImage(playURL));

        addKeyListener(this);
        

    }

    public Player createBird(int posX, int posY) {
        Animation flapping = new Animation();
        flapping.sumPanel(Toolkit.getDefaultToolkit().getImage(greenBird1), 100);
        flapping.sumPanel(Toolkit.getDefaultToolkit().getImage(greenBird2), 100);
        flapping.sumPanel(Toolkit.getDefaultToolkit().getImage(greenBird1), 100);
        flapping.sumPanel(Toolkit.getDefaultToolkit().getImage(greenBird3), 100);

        Player newBird = new Player(posX, posY, flapping);

        return newBird;
    }

    public void pipeReset(int numPipe) {
        pipe = (Pipes) (list.get(numPipe));
        pipe.setPosX(pipe.getPosX() + RETURN_RIGHT);
        int y = (-1) * ((int) (Math.random() * 218) + 125);
        pipe.setPosY(y);
    }

    public void resetPipes() {

        list = new LinkedList();
        int contPipes = 0;
        int gapX = 0;
        while (contPipes < TOTAL_PIPES) {
    
            pipe = new Pipes(gapX, 0);
            pipe.setGap(GAP_Y_LVL_1);
            list.push(pipe);
            contPipes++;
            gapX += GAP_X_LVL_1;
        }
    }

    public void start() {
        // thread declaration
        Thread hilo = new Thread(this);
        // starts the thread
        hilo.start();
    }

    public void stop() {

    }

    public void destroy() {

    }

    public void run() {
        // Saves the current system time
        currentTime = System.currentTimeMillis();

        // Updates and displays the animation until program is exited
        while (true) {
            if (!slowDown) {
                //Updates playerIcon
                update();

                // calls checkCollision
                checkCollision();
            } else {
                updateFrame();
            }
            // displays the frame
            repaint();

            // Pauses 100 milliseconds
            try {
                Thread.sleep(65);
            } catch (InterruptedException ex) {
            }
        }
    }

    // Updates position of all elements
    public void update() {
        // Determines the time that has elapsed since the Applet started running
        long timePassed = System.currentTimeMillis() - currentTime;

        // Saves the current time
        currentTime += timePassed;
        if (!gameOverAnimation) {
            for (int i = 0; i < list.size(); i++) {
                pipe = (Pipes) (list.get(i));

                pipe.move();
            }
        }

        timer += 1;
        playerIcon.move(timer);
        playerIcon.updateAnimation(timePassed);

        if (!gameOverAnimation) {
            if (floorPos <= floor.getIconWidth() * -1) {
                floorPos = 0;
            } else {
                floorPos -= GAME_SPEED;
            }
        }

        for (Pipes pipe : list) {
            if (score > 5) {
                pipe.setGap(GAP_Y_LVL_2);
            } else if (score > 10) {
                pipe.setGap(GAP_Y_LVL_3);
            }
        }
        try {
            Thread.sleep(0);
        } catch (InterruptedException ex) {
        }
    }

    //update frame on pause
    public void updateFrame() {
        // Determines the time that has elapsed since the Applet started running
        long timePassed
                = System.currentTimeMillis() - currentTime;

        // Saves the current time
        currentTime += timePassed;
        playerIcon.updateAnimation(timePassed);

        if (floorPos <= floor.getIconWidth() * -1) {
            floorPos = 0;
        } else {
            floorPos -= GAME_SPEED;
        }
        try {
            Thread.sleep(0);
        } catch (InterruptedException ex) {
        }
    }

    public void checkCollision() {
        if (playerIcon.getPosY() >= WINDOW_HEIGHT - floor.getIconHeight() && !gameOverAnimation) {
            crashed = true;
            gameOverAnimation = true;
            gameOverClip.play();
        }

        if (!gameOverAnimation) {
            for (Pipes pipe : list) {
                if (pipe.checkPipeCollision(playerIcon)) {
                    crashed = true;
                    gameOverAnimation = true;
                    gameOverClip.play();
                }

                // Adds point to score when a pipe is cleared
                if (pipe.getPosX() + PIPE_WIDTH < playerIcon.getPosX() && !pipe.isPassed()) {
                    score += 1;
                    pipe.setPassed(true);
                    scoreClip.play();
                }

                //for the resetting of pipes when reaching the end of the applet
                if (pipe.getPosX() + PIPE_WIDTH < 0) {
                    Pipes lastPipe = pipe;
                    int gapX = 0;
                    //get the last pipe to be drawn
                    for (Pipes nextPipe : list) {
                        if (lastPipe.getPosX() < nextPipe.getPosX()) {
                            lastPipe = nextPipe;
                        }
                        gapX += GAP_X_LVL_1;
                    }
                    //I have the lastPipe drawn
                    pipe.resetThisPipe(lastPipe, gapX);
                }

            }

        }

        for (int i = 0; i < list.size(); i++) {

        }

        if (gameOverAnimation && playerIcon.getPosY() >= WINDOW_HEIGHT) {
            slowDown = true;
            playerIcon.resetPosition();
            resetPipes();
           
        }

    }

    /**
     * This method paints graphics
     * @param g is the graphic object used to draw.
     * 
     */
    public void paint(Graphics g) {
        // Initialize the DoubleBufferr
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            gObj = dbImage.getGraphics();
        }

        // Refresh the background image
        gObj.setColor(getBackground());
        gObj.fillRect(0, 0, this.getSize().width, this.getSize().height);
        gObj.drawImage(background, 0, 0, this);

        for (int i = 0; i < list.size(); i++) {
            pipe = (Pipes) (list.get(i));

            gObj.drawImage(pipe.getPipeUp(), pipe.getPosX(), pipe.getPosY(), this);
            gObj.drawImage(pipe.getPipeDown(), pipe.getPosX(), pipe.getPosY() + pipe.getGap(), this);
        }

        if (gameOverAnimation) {
            gObj.setColor(Color.BLACK);
            gObj.fillRect(0, 0, getWidth(), getHeight());
            gObj.setColor(Color.WHITE);
            gObj.drawString("FAIL", getWidth()/2, getHeight()/3);
            gObj.setColor(Color.WHITE);
            gObj.drawString("You scored " + score + " points!" , getWidth() / 5, getHeight()/5);

            
        }

        // Update Foreground
        gObj.setColor(getForeground());
        paintFront(gObj);

        // Draw the updated image
        g.drawImage(dbImage, 0, 0, this);

        paintFront(g);
    }

    /**
     * The paint () method displays the animation
     */
    public void paintFront(Graphics g) {
        // Displays the current animation frame
        if (playerIcon != null) {

            if (slowDown) {
                g.drawImage(pause.getImage(), WINDOW_WIDTH / 2 - pause.getIconWidth() / 2, WINDOW_HEIGHT / 2 - pause.getIconHeight() / 2, this);
            }
            if (playCounter > 0) {
                playCounter--;
                g.drawImage(play.getImage(), WINDOW_WIDTH / 2 - pause.getIconWidth() / 2, WINDOW_HEIGHT / 2 - pause.getIconHeight() / 2, this);
            }
            // draws player icon
            g.drawImage(playerIcon.getImage(), playerIcon.getPosX(), playerIcon.getPosY(), this);


            g.drawImage(floor.getImage(), floorPos, WINDOW_HEIGHT - floor.getIconHeight(), this);
            g.drawImage(floor.getImage(), floor.getIconWidth() + floorPos, WINDOW_HEIGHT - floor.getIconHeight(), this);
            if (crashed) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                crashed = false;
            }

            // draw score
            // Font dataFont = g.getFont(); 
            g.setColor(Color.white);
    		g.setFont(new Font("Cosmic Sans MS",1,25));
            g.drawString("Score: " + score, 40, 65);
    

        } else {
            g.drawString("Cargando...", getWidth() / 2, getHeight() / 2);
        }

    }

    // CONTROLS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOverAnimation) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                playerIcon.flap();
                jumpClip.play();
                timer = 0;
                if (slowDown) {
                    playCounter = 5;
                }
                slowDown = false;
            } else if (e.getKeyCode() == KeyEvent.VK_P) {
                slowDown = !slowDown;
            }
        }else {
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                gameOverAnimation = false; 
                score = 0;
            }
        }

    }

   
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
