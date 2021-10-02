/**Eric Muniz
 * PP 3 Linked List with Enum
 */
package objects;

public class Painting {
	//Enum used to list CONSTANTS for an instance variable
	public enum Genre{
		ABSTRACT, FANTASY, ENVIORMENTAL, LANDSCAPE
	}
	
	private String artist;
	private Genre genre;
	private String era;
	
	//Constructors
	public Painting(String artist, Genre genre, String era){
		this.artist = artist;
		this.genre = genre;
		this.era = era;
	}
	public Painting(){
		artist = null;
		genre = null;
		era = null;
	}
	
	//Details what each enum Genre would be
	public void paintingDetails(){
		switch(genre){
		case ABSTRACT:
			System.out.println("Cool! What is it?");
			break;
		case FANTASY:
			System.out.println("I've had dreams about this piece.");
			break;
		case ENVIORMENTAL:
			System.out.println("This really captures the devistation of logging camps!");
			break;
		case LANDSCAPE:
			System.out.println("This is beautiful, I'm going to set this as my screen saver.");
			break;
		}
	}
	
	//Accessors
	public String getArtist(){
		return artist;
	}
	public Genre getGenre(){
		return genre;
	}
	public String getEra(){
		return era;
	}
	
	//Mutators
	public void setArtist(String artist){
		this.artist = artist;
	}
	public void setGenre(Genre genre){
		this.genre = genre;
	}
	public void setEra(String era){
		this.era = era;
	}
	
	//toString
	public String toString(){
		return "Artist: " + artist + " Genre: " + genre + " Era: " + era;
	}
	
}
