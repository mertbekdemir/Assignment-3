import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner 
{
   public static void main(String[] args)
   {
       System.out.println("----- New Test Run -----");
       
       Result result = JUnitCore.runClasses(PackageTestSuite.class);

       for (Failure failure : result.getFailures()) 
       {
           System.out.println("X " + failure.toString());
       }
       
       System.out.println("Y " + result.wasSuccessful());
   }
}
