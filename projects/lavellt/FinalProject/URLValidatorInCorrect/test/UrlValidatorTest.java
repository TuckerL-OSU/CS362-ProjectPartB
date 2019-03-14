// Richard Mitchell - mitchric
// Tucker Lavell - lavellt
// Matthew McLean - mcleanm


import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
//You can use this function to implement your manual testing
      String url = "";
//      String schemes[] = {"http", "https", "ftp"};

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
//      UrlValidator urlVal = new UrlValidator();
//      UrlValidator urlVal = new UrlValidator(schemes);
      System.out.println("============");
      System.out.println("Manual Tests:");
      System.out.println("============");
      System.out.println("Expected Valid URLs:");
      System.out.println(String.format("%-60s", url = "http://www.interglow.net") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "www.interglow.net") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "interglow.net") + "Expected: true\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "chrome://extensions/") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "https://www.google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "ftp://google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://ww3-www.google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://ww3.www.google.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google-test.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google_test.com") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.arpa") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.com.us") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.com/%2F") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.com/%0D%0A") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.state.va.us") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.state.va.us.gov") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/path?query_string#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/path") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/path?query_string") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/path#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.orst.edu:80/path?query-string#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "mailto://lavellt@oregonstate.edu") + "Expected: true\tActual: " + urlVal.isValid(url));

      System.out.println("\nExpected Invalid URLs:");
      System.out.println(String.format("%-60s", url = "http://www.amazon") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "!!!://www.amazon") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "httpwww.amazon.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "://www.amazon.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://bad!!!.gov") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "gopro://gopro.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "bipcoin://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "bipcoin1://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "chrome-extension://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "-extension://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "chrome-://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
//      System.out.println(String.format("%-60s", url = "chrome.extension://google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://ww3_www.google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://ww3~www.google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google~test.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.test~com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.test-com") + "Expected: false\tActual: " + urlVal.isValid(url));
      System.out.println(String.format("%-60s", url = "http://www.google.test_com") + "Expected: false\tActual: " + urlVal.isValid(url));

      // extreme length cases
      url = "http://www.one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-fourteen-fifteen-sixteen-seventeen-eighteen-nineteen-twenty-twentyone-twentytwo-twentythree-twentyfour-twentyfive-twentysix-twentyeight-twentynine-thirty-thirtyone-thirtytwo.com";
      System.out.println(String.format("%-60s", "http://www.1-32.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      url = "http://www.one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-fourteen-fifteen-sixteen-seventeen-eighteen-nineteen-twenty-twentyone-twentytwo-twentythree-twentyfour-twentyfive-twentysix-twentyeight-twentynine-thirty-thirtyone-thirtytwo-thirtythree-thirtyfour-thirtyfive-thirtysix-thirtyseven-thirtyeight-thirtynine-fourty.com";
      System.out.println(String.format("%-60s", "http://www.1-40.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      url = "http://www.one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-fourteen-fifteen-sixteen-seventeen-eighteen-nineteen-twenty-twentyone-twentytwo-twentythree-twentyfour-twentyfive-twentysix-twentyeight-twentynine-thirty-thirtyone-thirtytwo.google.com";
      System.out.println(String.format("%-60s", "http://www.1-32.google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      url = "http://one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-fourteen-fifteen-sixteen-seventeen-eighteen-nineteen-twenty-twentyone-twentytwo-twentythree-twentyfour-twentyfive-twentysix-twentyeight-twentynine-thirty-thirtyone-thirtytwo.google.com";
      System.out.println(String.format("%-60s", "http://1-32.google.com") + "Expected: false\tActual: " + urlVal.isValid(url));
      url = "http://www.google.one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-fourteen-fifteen-sixteen-seventeen-eighteen-nineteen-twenty-twentyone-twentytwo-twentythree-twentyfour-twentyfive-twentysix-twentyeight-twentynine-thirty-thirtyone-thirtytwo";
      System.out.println(String.format("%-60s", "http://www.google.1-32") + "Expected: false\tActual: " + urlVal.isValid(url));
      url = "";
      System.out.println(String.format("%-60s", "Blank URL") + "Expected: false\tActual: " + urlVal.isValid(url));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
