package exception;

//Must extend Exception
public class MyException extends Exception{
		public MyException(){
			super("My exception occured!");
		}
		
		public MyException(String msg){
			super(msg);
		}
}
