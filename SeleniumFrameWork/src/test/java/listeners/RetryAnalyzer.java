package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//this is a class to run failed test, its called in TestNGRetryFailedDemo.java class
public class RetryAnalyzer implements IRetryAnalyzer {
 
  private int retryCount = 0;
  private static final int maxRetryCount = 3;
 
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}
