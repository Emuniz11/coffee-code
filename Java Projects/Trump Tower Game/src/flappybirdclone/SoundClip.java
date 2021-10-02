package flappybirdclone;

/**
 * This class is for sound clips
 *
 */
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;

public class SoundClip {

	private AudioInputStream sample;
	private Clip clip;
	private boolean looping = false;
	private int repeat = 0;
	private String filename = "";

	/**
	 * Constructor default
	 */
	public SoundClip() {
		try {
			//creates buffer for sound
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) { 

		}
	}

	/** 

	 * Constructor with parameters, which load call load
	 * This loads the sound file.
	 */
	public SoundClip(String filename) {
		//Call to the constructor
		this();
		//Load sound 
		load(filename);
	}

	/** 
	 * Access method that returns an object of type Clip
	 * 
	 */
	public Clip getClip() { 
		return clip; 
	}

	/** 
	 * Modifier method used to modify if the sound is repeated.
	 *
	 */
	public void setLooping(boolean looping) {
		this.looping = looping; 
	}

	/** 
	 * Access method that returns a boolean to see if there is repetition.
	 * 
	 */
	public boolean getLooping() {
		return looping;
	}

	/** 
	 * Modifier method used to define the number of repetitions.
	 * @param _repeat Is an <code> integer </ code> which is the number of repetitions.
	 */
	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	/** 
	 * Access method that returns the number of repetitions.
	 * 
	 */
	public int getRepeat() { 
		return repeat; 
	}

	/**
	 * Modifier method that names the file.
	 * 
	 */
	public void setFilename(String filename) { 
		this.filename = filename; 
	}

	/** 
	 * Access method that returns the file name.
	 *
	 */
	public String getFilename() { 
		return filename;
	}

	/**
	 * Method that verifies if the audio file is loaded.
	 * 
	 */
	public boolean isLoaded() {
		return (boolean)(sample != null);
	}

	/** 
	 * Access method that returns the file url
	 * 
	 */
	private URL getURL(String filename) {
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
                        if(url==null){
                            System.out.println("No pude obtener la url.");
                        }
		}
		catch (Exception e) { 

		}
		return url;
	}

	/** 
	 * Method that loads the sound file.
	 
	 */
	public boolean load(String audiofile) {
		try {
			setFilename(audiofile);
			sample = AudioSystem.getAudioInputStream(getURL(filename));
			clip.open(sample);
			return true;

		} catch (IOException e) {
			return false;
		} catch (UnsupportedAudioFileException e) {
			return false;
		} catch (LineUnavailableException e) {
			return false;
		}
	}

	/**
	 * Method that plays the sound.
	 */
	public void play() {
		// Exit if the sound is not loaded
		if (!isLoaded()) 
			return;
		// Restart the sound clip
		clip.setFramePosition(0);

		// Plays the sound with optional repeat.
		if (looping)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		else
			clip.loop(repeat);
	}

	/**
	 * Method that stops the sound.
	 */
	public void stop() {
		clip.stop();
	}

}
