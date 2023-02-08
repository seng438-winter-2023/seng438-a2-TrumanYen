package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.*;
import org.junit.*;
import org.jmock.*;

import java.util.List;
import java.util.ArrayList;

public class DataUtilitiesTest{
	
	// Is this even necessary?
	private DataUtilities testDataUtilities;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    // Not sure what to put here
    @Before
    public void setUp() throws Exception { 
    }


//    @Test
//    public void calculateColumnTotalForTwoValues() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(2));
//                one(values).getValue(0, 0);
//                will(returnValue(7.5));
//                one(values).getValue(1, 0);
//                will(returnValue(2.5));
//            }
//        });
//        double result = DataUtilities.calculateColumnTotal(values, 0);
//        // verify
//        assertEquals(result, 10.0, .000000001d);
//        // tear-down: NONE in this test method
//    }
    
    @Test
    public void testGetCumalitivePercentages() {
        // setup
        Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class, "values");
        
        final List<Integer> keys = new ArrayList<Integer>();
        keys.add(0);
        keys.add(1);
        
        // what is comparable? Will that be our equivalence classes
        
        
        mockingContext.checking(new Expectations() {
            {
            	// Trying to initialize a KeyedValues object using getters
            	 oneOf(values).getKey(0);
                 will(returnValue(0));
                 oneOf(values).getKey(1);  will(returnValue(1));
            	
//                one(values).getValue(0);
//                will(returnValue(2));
//                one(values).getValue(1);
//                will(returnValue(2));
//                
//                one(values).getItemCount();
//                will(returnValue(2));
//                
//                one(values).getKeys();
//                will(returnValue(keys));                               
                
            }
        });
        
        // I have a feeling we should setup outside test function??
        
        final KeyedValues expected = mockingContext.mock(KeyedValues.class, "expected");
        
        mockingContext.checking(new Expectations() {
            {
            	// Trying to initialize a KeyedValues object using getters
            	 one(expected).getKey(0);
                 will(returnValue(0));
                 one(expected).getKey(1);
                 will(returnValue(1));
            	
//                one(expected).getValue(0);
//                will(returnValue(0.5));
//                one(expected).getIndex(1);
//                will(returnValue(1.0));
                
//                one(expected).getItemCount();
//                will(returnValue(2));
//                
//                
//                one(expected).getKeys();
//                will(returnValue(keys)); 
                
            }
        });        
        
        // Is there somewhere that tells us how to build our mock objects?
        
        KeyedValues result = DataUtilities.getCumulativePercentages(values);                
        
        // verify
         assertEquals(result, expected);
        // tear-down: NONE in this test method
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    
    

}
