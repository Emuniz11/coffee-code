package speaker;
	
public class SpeakerDriver {

	public static void main(String[] args) {
		Speaker person1 = new Dog ("Taz", 4);
		Speaker person2 = new Philosopher("E");
		
		//person1 = person2;//This can work because the reference variable of both are Speaker.
		
		//(Philosopher)person1.pontificate();//Since the reference variable of person1 is speaker the 
		//compiler looks to the speaker interface for the method. Casting person1 into a philosopher will
		//allow the program to compile.
		
		person1.speak();
		person2.speak();
		
	}

}

