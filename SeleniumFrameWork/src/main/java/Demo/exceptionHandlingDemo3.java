package Demo;

public class exceptionHandlingDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!............");
		int i= 1/0;
		System.out.println("completed");
		throw new ArithmeticException("not a valid operation");


	}

}
