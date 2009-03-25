package AnalyzerPackage;
import org.junit.* ;
import static org.junit.Assert.* ;

public class DriverTest {
	 
	@Test
	   public void test_ReturnPrintout() {
	      System.out.println("Test if Driver returns the sample data") ;
	     
	      TestObject test = new TestObject("sampleData.txt");
	      
	      String result = "Datapoint 10.0, 8.0, 2Datapoint 10.0, 8.5, 2Datapoint 12.0, 9.0, 2Datapoint 12.1, 9.5, 2Datapoint 12.2, 10.0, 2Datapoint 12.4, 10.5, 2Datapoint 13.0, 11.0, 2Datapoint 12.9, 11.5, 2Datapoint 10.2, 12.0, 2";
	            
	      assertTrue(test.runTest().equals(result));
	   }

}
