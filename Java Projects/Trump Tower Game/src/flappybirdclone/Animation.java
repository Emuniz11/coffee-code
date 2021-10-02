package flappybirdclone; 
import java.awt.Image;
import java.util.ArrayList;

/**
	The Animation class handles a series of images (frames)
	And the amount of time each picture is displayed.
*/

public class Animation{
	
	private ArrayList pictures;
	private int pictureIndex;
	private long frameTime;
	private long totalDuration;
	
	/**	
		Create a new empty animation
	*/
	public Animation(){
		pictures = new ArrayList();
		totalDuration = 0;
		start();
	}
	
	/**
		Add a frame to the animation with the duration
		Indicated (time the image is displayed)
	*/
	// sumPanel, 
	public synchronized void sumPanel(Image image, long duration){
		totalDuration += duration;
		pictures.add(new AnimationFrame(image, totalDuration));
	}
	
	// Initializes the animation from the beginning.
	public synchronized void start(){
		frameTime = 0;
		pictureIndex = 0;
	}
	
	/**

		Updates the current image (frame) of the animation,
		if required.
	*/
	public synchronized void update(long timePassed){
		if (pictures.size() > 1){
			frameTime += timePassed;
			
			if (frameTime >= totalDuration){
				frameTime = frameTime % totalDuration;
				pictureIndex = 0; 
			}
			
			while (frameTime > getPicture(pictureIndex).finalTime){
				pictureIndex++;
			}
		}
	}
	
	/**

		Captures the current animation image. Returns null
		If the animation has no images.
	*/
	public synchronized Image getImagen(){
		if (pictures.size() == 0){
			return null;
		}
		else {
			return getPicture(pictureIndex).image;
		}
	}
	
	private AnimationFrame getPicture(int i){
		return (AnimationFrame)pictures.get(i);
	}

        public class AnimationFrame{
		
		Image image;
		long finalTime;
		
		public AnimationFrame(){
			this.image = null;
			this.finalTime = 0;
		}
		
		public AnimationFrame(Image image, long finalTime){
			this.image = image;
			this.finalTime = finalTime;
		}
		
		public Image getImage(){
			return image;
		}
		
		public long getFinalTime(){
			return finalTime;
		}
		
		public void setImage (Image image){
			this.image = image;
		}
		
		public void setFinalTime(long finalTime){
			this.finalTime = finalTime;
		}
	}
		
}