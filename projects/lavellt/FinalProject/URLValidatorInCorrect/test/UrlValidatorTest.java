// Richard Mitchell - mitchric
// Tucker Lavell - lavellt
// Matthew McLean - mcleanm


import java.util.ArrayList;
import java.util.Random;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public int numRandomTestUrls = 1000;
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   
   }
   
   //Generates a random set of ValidationPairs from the passed array lists of url parts
   public ValidationPair getRandomUrl(ArrayList<ValidationPair> schemes, ArrayList<ValidationPair> authorities, ArrayList<ValidationPair> paths, ArrayList<ValidationPair> queries)
   {
	   Random randGen = new Random();
	   
	   ValidationPair pair = new ValidationPair();
	   
	   ValidationPair scheme = schemes.get(randGen.nextInt(schemes.size()));
	   pair.url += scheme.url;
	   pair.valid &= scheme.valid;
	   
	   ValidationPair authority = authorities.get(randGen.nextInt(authorities.size()));
	   pair.url += authority.url;
	   pair.valid &= authority.valid;
	   
	   ValidationPair path = paths.get(randGen.nextInt(paths.size()));
	   pair.url += path.url;
	   pair.valid &= path.valid;
	   
	   ValidationPair query = queries.get(randGen.nextInt(queries.size()));
	   pair.url += query.url;
	   pair.valid &= query.valid;
	   
	   return pair;
   }
   
   //Create array list of validation pairs with passed values, set valid flag on each to passed valid value
   public ArrayList<ValidationPair> getValidationPairSets(String[] values, boolean valid)
   {
	   ArrayList<ValidationPair> set = new ArrayList<ValidationPair>();
	   
	   for(int i = 0; i < values.length; i++)
	   {
		   set.add(new ValidationPair(values[i], valid));
	   }
	   
	   return set;
   }
   
   //Create array list of validation from two sets of values and their corresponding validity
   public ArrayList<ValidationPair> getValidationPairSets(String[] values1, boolean valid1, String[] values2, boolean valid2)
   {
	   ArrayList<ValidationPair> set = new ArrayList<ValidationPair>();
	   
	   for(int i = 0; i < values1.length; i++)
	   {
		   set.add(new ValidationPair(values1[i], valid1));
	   }
	   for(int i = 0; i < values2.length; i++)
	   {
		   set.add(new ValidationPair(values2[i], valid2));
	   }

	   return set;
   }

   
   public void testSchemes()
   {	
	   ArrayList<ValidationPair> schemes = getValidationPairSets(validSchemes, true, invalidSchemes, false);
	   ArrayList<ValidationPair> authorities = getValidationPairSets(validAuthorities, true);
	   ArrayList<ValidationPair> paths = getValidationPairSets(validPaths, true);
	   ArrayList<ValidationPair> queries = getValidationPairSets(validQueries, true);
	   
	   UrlValidator urlVal = new UrlValidator();
	   for(int i = 0; i < numRandomTestUrls; i++)
	   {
		   ValidationPair testUrl = getRandomUrl(schemes, authorities, paths, queries);
		   if(testUrl.valid != urlVal.isValid(testUrl.url))
		   {
			   System.out.println("Test failed. Url: " + testUrl.url + " Expected: " + testUrl.valid + " Actual: " + urlVal.isValid(testUrl.url));
		   }
		   assertEquals(testUrl.valid, urlVal.isValid(testUrl.url));
	   }
   }
   
   public void testAuthorities()
   {	
	   ArrayList<ValidationPair> schemes = getValidationPairSets(validSchemes, true);
	   ArrayList<ValidationPair> authorities = getValidationPairSets(validAuthorities, true, invalidAuthorities, false);
	   ArrayList<ValidationPair> paths = getValidationPairSets(validPaths, true);
	   ArrayList<ValidationPair> queries = getValidationPairSets(validQueries, true);
	   
	   UrlValidator urlVal = new UrlValidator();
	   for(int i = 0; i < numRandomTestUrls; i++)
	   {
		   ValidationPair testUrl = getRandomUrl(schemes, authorities, paths, queries);
		   if(testUrl.valid != urlVal.isValid(testUrl.url))
		   {
			   System.out.println("Test failed. Url: " + testUrl.url + " Expected: " + testUrl.valid + " Actual: " + urlVal.isValid(testUrl.url));
		   }
		   assertEquals(testUrl.valid, urlVal.isValid(testUrl.url));
	   }
   }
   
   //paths
   public void testPaths()
   {
	   ArrayList<ValidationPair> schemes = getValidationPairSets(validSchemes, true);
	   ArrayList<ValidationPair> authorities = getValidationPairSets(validAuthorities, true);
	   ArrayList<ValidationPair> paths = getValidationPairSets(validPaths, true, invalidPaths, false);
	   ArrayList<ValidationPair> queries = getValidationPairSets(validQueries, true);
	   
	   UrlValidator urlVal = new UrlValidator();
	   for(int i = 0; i < numRandomTestUrls; i++)
	   {
		   ValidationPair testUrl = getRandomUrl(schemes, authorities, paths, queries);
		   if(testUrl.valid != urlVal.isValid(testUrl.url))
		   {
			   System.out.println("Test failed. Url: " + testUrl.url + " Expected: " + testUrl.valid + " Actual: " + urlVal.isValid(testUrl.url));
		   }
		   assertEquals(testUrl.valid, urlVal.isValid(testUrl.url));
	   }
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }

   public void testIsValidUnitTest() {
	  UrlValidator urlVal = new UrlValidator();

	  System.out.println("Unit testing url http://www.apache.org"); 
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValid("http://www.apache.org"));

	  System.out.println("\nUnit testing url ftp://billgates:moremoney@files.microsoft.com/special"); 
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValid("ftp://billgates:moremoney@files.microsoft.com/special"));
	  
	  
	  System.out.println("\nUnit testing url 3ht://yahoo.com"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValid("3ht://yahoo.com"));
	  
	  System.out.println("\nUnit testing url http:/bing.com"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValid("http:/bing.com"));
	  
	  
	  System.out.println("\nUnit testing url http:marvel.com"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValid("http:marvel.com"));
	  
	  System.out.println("\nUnit testing url http/starwars.com"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValid("http/starwars.com")); 
	  
	  System.out.println("\nUnit testing url ://nfl.com"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValid("://nfl.com"));
   }
   
   public void testIsValidSchemeUnitTest() {
	  UrlValidator urlVal = new UrlValidator();

	  System.out.println("\nUnit testing scheme http://"); 
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidScheme("http://"));

	  System.out.println("\nUnit testing scheme ftp://"); 
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidScheme("ftp://"));
	  
	  
	  System.out.println("\nUnit testing scheme 3ht://"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValidScheme("3ht://"));
	  
	  System.out.println("\nUnit testing scheme http:/"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValidScheme("http:/"));
	  
	  
	  System.out.println("\nUnit testing scheme http:"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValidScheme("http:"));
	  
	  System.out.println("\nUnit testing scheme http/"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValidScheme("http/")); 
	  
	  System.out.println("\nUnit testing scheme ://"); 
	  System.out.println("Expecting false");
	  System.out.println("Result = " + urlVal.isValidScheme("://"));
   } 
   
   public void testIsValidQueryUnitTest() {
	  UrlValidator urlVal = new UrlValidator();
	  
	  System.out.println("\nUnit testing query ?hpt=sitenav");
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidQuery("?hpt=sitenav"));
	  
	  System.out.println("\nUnit testing query ?action=view");
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidQuery("?action=view"));
	  
	  System.out.println("\nUnit testing query ?action=edit&mode=up");
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidQuery("?action=edit&mode=up"));
	  
	  System.out.println("\nUnit testing empty query");
	  System.out.println("Expecting true");
	  System.out.println("Result = " + urlVal.isValidQuery(""));
   }
   // Sets of valid and invalid parts of urls
   public String[] validSchemes = {"http://", "https://", "ftp://"};
   public String[] invalidSchemes = {"htp://", "tthp://", "ht://", "http:/", "https:/"};
   public String[] validAuthorities = {"0.0.0.0:1", "255.255.255.255:65535", "www.google.com", "www.cooltest.edu", "www.huh.com", "ww.test.com", "test.com", "test.cz"};
   public String[] invalidAuthorities = {"256.0.0.0:3000", "255.255.255.255:65536", "0.0.0.0:-1", "ww.test.c0m"};
   public String[] validPaths = {"", "/new", "/test/data/here"};
   public String[] invalidPaths = {"/test/data////here", "/../test"};
   public String[] validQueries = {"", "?test=boork&huh=okay"}; 
}
