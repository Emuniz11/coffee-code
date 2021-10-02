package driver;

import exception.*;

public class MyExceptionDriver {
										//This is saying that I may throw an exception
										//Notice this one is "throws" rather than "throw" 
										//You must have this to throw an exception
	public static void main(String[] args) throws MyException{
		int num1 = 10, num2 = 20;
		//int num1 = 20, num2 = 10;
		
		try{
			if (num1 < num2)
				//if you throw an exception you must include it in the method header
				//This is what appears when the if statement is not true
				//This must be called in the try block
				throw new MyException("num1 < num2");
		}
		catch (MyException me){
			System.out.println(me);
			System.out.println("Fix it.");
		}
		System.out.println("End of main");
	}

}
//If your using a method that declares an exception you must use it in a Try Catch Block