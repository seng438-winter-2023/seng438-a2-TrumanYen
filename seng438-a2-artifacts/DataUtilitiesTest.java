package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.*;
import org.junit.*;
import org.jmock.*;

public class DataUtilitiesTest{
	
	private KeyedValues values1;
	private KeyedValues values2;
	private KeyedValues values3;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception { 
    	// setup
        Mockery mockingContext = new Mockery();
        
        values1 = mockingContext.mock(KeyedValues.class, "values1");
        values2 = mockingContext.mock(KeyedValues.class, "values2");
        values3 = mockingContext.mock(KeyedValues.class, "values3");
        
        // ECT - keyed value is a double, int and string?
        // try negatives, null and positives for all ECT's
        
        mockingContext.checking(new Expectations() {
            {
            	// Trying to initialize a KeyedValues object using getters             
            	allowing(values1).getItemCount();
                will(returnValue(2));
                allowing(values1).getValue(1);
                will(returnValue(2));
                allowing(values1).getValue(0);
                will(returnValue(2));
                allowing(values1).getKey(0);
                will(returnValue(0));
                allowing(values1).getKey(1);
                will(returnValue(1));             
                
                
                allowing(values2).getItemCount();
                will(returnValue(1));
                allowing(values2).getValue(0);
                will(returnValue(-4));
                allowing(values2).getKey(0);
                will(returnValue("Hello"));
                
                allowing(values3).getItemCount();
                will(returnValue(1));
                allowing(values3).getValue(0);
                will(returnValue(0));
                allowing(values3).getKey(0);
                will(returnValue(3.7666));
                
                                
                
            }
        });
    }

    
    @Test
    public void testGetCumalitivePercentagesReturnsCorrectValueAtIndexZeroForIntKeys() {                      
       
        KeyedValues result = DataUtilities.getCumulativePercentages(values1);                           
        assertEquals(0.5, result.getValue(0));      
    }
    
    @Test
    public void testGetCumalitivePercentagesReturnsCorrectValueAtIndexOneForIntKeys() {                      
       
        KeyedValues result = DataUtilities.getCumulativePercentages(values1);                           
        assertEquals(1, result.getValue(1));      
    }
    
    @Test
    public void testGetCumalitivePercentagesThrowsExceptionForValueNegativeInt() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values2);                           
        assertEquals(1, result.getValue(0));
        // shouldnt it throw exception
    }
    
    @Test
    public void testGetCumalitivePercentagesThrowsExceptionForValueZero() {
        KeyedValues result = DataUtilities.getCumulativePercentages(values3);
        assertEquals(1, result.getValue(0));
        // shouldnt it throw exception
    }
    
    @Test
    public void createNumberArrayTestPositiveDoubles() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = { 0.1, 0.2, 0.3 };

        Number[] expected = new Number[3];
        expected[0] = 0.1;
        expected[1] = 0.2;
        expected[2] = 0.3;

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArray fails for input of doubles", expected, result);
    }

    @Test
    public void createNumberArrayTestNegativeDoubles() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = {-0.1, -0.2, -0.3};

        Number[] expected = new Number[3];
        expected[0] = -0.1;
        expected[1] = -0.2;
        expected[2] = -0.3;

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArray fails for input of negative doubles", expected, result);
    }

    @Test
    public void createNumberArrayTestEmptyArray() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = {};

        Number[] expected = new Number[0];

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArea fails for empty array", expected, result);
    }

    @Test(expected = Exception.class)
    public void createNumberArrayTestNullValues() {
        Number[] result = DataUtilities.createNumberArray(null);
    }

    @Test
    public void create2DNumberArrayTestPositiveDoubles() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = { { 0.1, 0.00002 }, { 0.0001, 0.5 } };

        Number[][] expected = new Number[2][2];
        expected[0][0] = 0.1;
        expected[0][1] = 0.00002;
        expected[1][0] = 0.0001;
        expected[1][1] = 0.5;

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for 2d double array", expected, result);
    }
    
    @Test
    public void create2DNumberArrayTestNegativeDoubles() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = { { -0.1, -0.00002 }, { -0.0001, -0.5 } };

        Number[][] expected = new Number[2][2];
        expected[0][0] = -0.1;
        expected[0][1] = -0.00002;
        expected[1][0] = -0.0001;
        expected[1][1] = -0.5;

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for 2d negative double array", expected, result);
    }

    @Test
    public void create2DNumberArrayTestEmptyArray() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = {};

        Number[][] expected = new Number[0][0];

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for empty double array", expected, result);
    }
    
    @Test(expected = Exception.class)
    public void createNumberArray2DTestNullValues() {
        Number[][] result = DataUtilities.createNumberArray2D(null);
    }
        
    
    // ECT's keys are doubles, integers and strings
    // ECT's Boundary values are null, negatives and positives (if applicable)
    
    

    @After
    public void tearDown() throws Exception {
    }
    

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    
    

}


//I have a feeling we should setup outside test function??

//final KeyedValues expected = mockingContext.mock(KeyedValues.class, "expected");
//
//mockingContext.checking(new Expectations() {
//    {
//    	// Trying to initialize a KeyedValues object using getters
//    	 one(expected).getKey(0);
//         will(returnValue(0));
//         one(expected).getKey(1);
//         will(returnValue(1));
//    	
//        one(expected).getValue(0);
//        will(returnValue(0.5));
//        one(expected).getIndex(1);
//        will(returnValue(1.0));
//        
//        one(expected).getItemCount();
//        will(returnValue(2));
//        
//    }
//});  
