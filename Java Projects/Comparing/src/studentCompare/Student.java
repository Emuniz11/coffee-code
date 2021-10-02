package studentCompare;

public class Student implements Comparable <Student>{
	private String name;
	private int age;
	
	public Student(String name, int age){
	this.name = name;
	this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	//It's best to define your own equals method so it can compare exactly what you need.
	public boolean equals (Student other){
		if(name.equals(other.getName())){
			if(age==other.getAge()){
				return true;
			}
		}
		return false;
	}

	public int compareTo(Student other) {
		if (this.name.equals(other.getName())){
			if(this.age == other.getAge()){
				return 0;
			}
			else if(this.age < other.getAge()){
				return -1;
			}
			else {
				return -1;
			}
		}
		else if(this.name.compareTo(other.getName()) < 0){
			return -1;
		}
		else{
			return 1;
		}
	}
	

}
