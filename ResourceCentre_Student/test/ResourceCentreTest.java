import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc;
	private Camcorder cc1;
	private Chromebook cb;
	private Chromebook cb1;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc1 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb1 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
public void addChromebookTest() {
        
        assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);
        ResourceCentre.addChromebook(chromebookList, cb1);
        assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
        
        //The item just added is as same as the first item of the list
        assertSame("Test that Camcorder is added same as 1st item of the list?", cb1, chromebookList.get(0));
        
        ResourceCentre.addChromebook(chromebookList, cb1);
        assertEquals("Test if that Camcorder arraylist size is 1?", 2, chromebookList.size());
        
        //fail("Not yet implemented");
        // write your code here
    }
    
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
        //checks if itemlist is not null, but is empty instead
        assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);
        
        //tests if the list retrieved from ResourceCenter is empty
        String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
        String testOutput = "";
        assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
        
        //Given an empty list, after adding 2 items, test if the size of the list is 2
        ResourceCentre.addChromebook(chromebookList, cb1);
        ResourceCentre.addChromebook(chromebookList, cb1);
        assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());
        
        //test if the expected output string same as the list of camcorders retrieved from the SourceCentre
        allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

        testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
        testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
    
        assertEquals("Check that ViewAllChromebookList", testOutput, allChromebook);

  
    }
	@Test
	public void doLoanCamcorderTest() { //darilynn
		
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		boolean check = false;
		check = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "21-7-20");
		//tests if isLoaned == true, will return false if isAvailable() == false
		assertTrue("If isLoaned boolean is true and isAvailable boolean is false, returns true", check);

		
	}	
	
	@Test
	public void doLoanChromebookTest() { //darilynn
		
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
        //Given an empty list, after adding 2 items, test if the size of the list is 2
        ResourceCentre.addChromebook(chromebookList, cb);
        ResourceCentre.addChromebook(chromebookList, cb1);
        assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());
        
      //tests if isLoaned == true, will return false if isAvailable() == false
        boolean check = false; 
        check = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "21-7-20");
        assertTrue(check);	
        

	}
	
	@Test
	public void doReturnCamcorderTest() { //darilynn
		//tag CC0011
		doLoanCamcorderTest();
		boolean returned = false;
		returned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		
		//checks if it's being returned by checking if boolean is true
		assertTrue("checks if its returned, if its true its returned", returned);
		
		
	}
	@Test
	public void doReturnChromebookTest() { //darilynn
		//loaning
		//tag CB0011
		
		assertNotNull("Test if there is valid Chromebook arraylist to",chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		
		//Error Occurs
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Test if available chromebook CC0011 is returned -false" , isReturned);
		
	}
	
	@After
	public void tearDown() throws Exception {
		cc = null;
		cc1 = null;
		cb = null;
		cb1 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
