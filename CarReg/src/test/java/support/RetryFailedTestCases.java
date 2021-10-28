package support;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    //Retry count set to 2 on failure, Reruns failed tests twice
    private final int maxRetryCnt = 2;
    private int retryCnt = 0;

    public boolean retry(ITestResult result) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt + 1));
            retryCnt++;
            return true;
        }
        return false;
    }

}
