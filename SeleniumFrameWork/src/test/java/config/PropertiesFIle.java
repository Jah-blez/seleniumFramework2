package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import pages.testNGDemo;

public class PropertiesFIle {
	
	public static Properties prop= new Properties();
	static String projectpath = System.getProperty("user.dir");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getproperties();
		setproperties();
		getproperties();
	}

	public static void getproperties() {
		try {
			
			
			InputStream input = new FileInputStream(projectpath +"/src/test/java/config/config,properties");
			prop.load(input);
			String browser =prop.getProperty("browser");
			System.out.println(browser);
			testNGDemo.browserName= browser;
		} 

		catch (Exception exp) {
			// TODO Auto-generated catch block

			System.out.println("message is" + exp.getMessage() ); 
			System.out.println("cause is" + exp.getCause() ); 
			exp.printStackTrace();
		}
	}
		
		public static void setproperties() {
		
			try {
				OutputStream output = new FileOutputStream(projectpath +"/src/test/java/config/config,properties");
				prop.setProperty("result", "pass");
				prop.store(output, null);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		

	

}
