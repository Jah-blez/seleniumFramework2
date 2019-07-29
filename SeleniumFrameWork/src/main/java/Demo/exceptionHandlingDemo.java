package Demo;

public class exceptionHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("Hello World!............");
			int i= 1/0;
			System.out.println("completed");
		}
		
		catch(Exception exp) {
			System.out.println("I am inside catch block");
			System.out.println("message is: " + exp.getMessage());
			System.out.println("Cause is: "+ exp.getCause());

			System.out.println("stack trace is:" + exp.getStackTrace()); 
			exp.printStackTrace();
		}
		
		finally {
			System.out.println("i am inside finally block");
		}

	}

}
