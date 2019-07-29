package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.Logger;

public class log4jDemo {
	
	private static Logger logger = LogManager.getLogger(log4jDemo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n Hello world \n");
		
		logger.info("this is an information message");
		logger.error("this is an error message");
		logger.fatal("This is a fatal message");
		logger.warn("This is a warning message");
		logger.trace("this is a trace message");
		
		System.out.println("\n completed");
		
	}

}
