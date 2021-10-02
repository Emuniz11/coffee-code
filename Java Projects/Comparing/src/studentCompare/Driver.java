package studentCompare;

public class Driver {

	public static void main(String[] args) {
		Student s1 = new Student("Bob", 23);
		Student s2 = new Student("Will", 21);
		
		if(s1.equals(s2))
			System.out.println("S1 and S2 are the same.");
		else {
			System.out.println("S2 and S2 are different.");
		}
		if (s1.compareTo(s2) < 0){
			System.out.println("S1 comes before S2.");
		}
		else if(s1.compareTo(s2) > 0){
			System.out.println("S2 comes before S1.");
		}
		else{
			System.out.println("S1 and S2 are equal.");
		}
	}

}
