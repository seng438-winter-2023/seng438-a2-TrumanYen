package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {
    private Range exampleRangeOne;
    private Range exampleRangeTwo;
    private Range exampleRangeThree;
    private Range classOneRange;
    private Range classTwoRange;
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRangeOne = new Range(-10, 10);
    	exampleRangeTwo = new Range(20, 50);
    	exampleRangeThree = new Range(-40, -20);
    	exampleRange = new Range(-1, 1);
    	classOneRange = new Range(0, 5);
		classTwoRange = new Range(5, 5);
    }
    

    @Test
    public void test_negLower_negUpper_lowerEqualUpper() throws Exception{
    	double lower = -20;
    	double upper = -20;
    	Range testRange = new Range(lower,upper);
    	assertEquals("The lower bound should be "+lower,
    	        lower, testRange.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be "+upper,
    	        upper, testRange.getUpperBound(), .000000001d);
    }
    @Test(expected = Exception.class)
    public void test_negLower_negUpper_lowerGreaterUpper() {
    	double lower = -10;
    	double upper = -20;
    	Range testRange = new Range(lower,upper);
    }
    @Test(expected = Exception.class)
    public void test_zeroLower_negUpper() {
    	double lower = 0;
    	double upper = -20;
    	Range testRange = new Range(lower,upper);
    }
    @Test(expected = Exception.class)
    public void test_posLower_negUpper() {
    	double lower = 20;
    	double upper = -20;
    	Range testRange = new Range(lower,upper);
    }
    
    @Test
    public void test_negLower_zeroUpper() throws Exception{
    	double lower = -20;
    	double upper = 0;
    	Range testRange = new Range(lower,upper);
    	assertEquals("The lower bound should be "+lower,
    	        lower, testRange.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be "+upper,
    	        upper, testRange.getUpperBound(), .000000001d);
    }
    @Test
    public void test_zeroLower_zeroUpper() throws Exception{
    	double lower = 0;
    	double upper = 0;
    	Range testRange = new Range(lower,upper);
    	assertEquals("The lower bound should be "+lower,
    	        lower, testRange.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be "+upper,
    	        upper, testRange.getUpperBound(), .000000001d);
    }
    @Test(expected = Exception.class)
    public void test_posLower_zeroUpper() {
    	double lower = 20;
    	double upper = 0;
    	Range testRange = new Range(lower,upper);
    }
    @Test
    public void test_zeroLower_posUpper() throws Exception{
    	double lower = 0;
    	double upper = 10;
    	Range testRange = new Range(lower,upper);
    	assertEquals("The lower bound should be "+lower,
    	        lower, testRange.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be "+upper,
    	        upper, testRange.getUpperBound(), .000000001d);
    }
    @Test
    public void test_posLower_posUpper_lowerEqualUpper() throws Exception{
    	double lower = 10;
    	double upper = 10;
    	Range testRange = new Range(lower,upper);
    	assertEquals("The lower bound should be "+lower,
    	        lower, testRange.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be "+upper,
    	        upper, testRange.getUpperBound(), .000000001d);
    }
    @Test(expected = Exception.class)
    public void test_posLower_posUpper_lowerGreaterUpper() {
    	double lower = 20;
    	double upper = 10;
    	Range testRange = new Range(lower,upper);
    }


    @Test
    public void exampleRangeOneLowerBoundTest() {
        assertEquals("The lower bound of exampleRangeOne should be -10",
        -10, exampleRangeOne.getLowerBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeTwoLowerBoundTest() {
        assertEquals("The lower bound of exampleRangeTwo should be 20",
        20, exampleRangeTwo.getLowerBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeThreeLowerBoundTest() {
        assertEquals("The lower bound of exampleRangeThree should be -40",
        -40, exampleRangeThree.getLowerBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeOneUpperBoundTest() {
        assertEquals("The upper bound of exampleRangeOne should be 10",
        10, exampleRangeOne.getUpperBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeTwoUpperBoundTest() {
        assertEquals("The upper bound of exampleRangeTwo should be 50",
        50, exampleRangeTwo.getUpperBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeThreeUpperBoundTest() {
        assertEquals("The upper bound of exampleRangeThree should be -20",
        -20, exampleRangeThree.getUpperBound(), .000000001d);
    }
    
    @Test
    public void exampleRangeOneLengthTest() {
        assertEquals("The length of exampleRangeOne should be 20",
        20, exampleRangeOne.getLength(), .000000001d);
    }
    
    @Test
    public void exampleRangeTwoLengthTest() {
        assertEquals("The length of exampleRangeOne should be 30",
        30, exampleRangeTwo.getLength(), .000000001d);
    }
    
    @Test
    public void exampleRangeThreeLengthTest() {
        assertEquals("The length of exampleRangeThree should be 20",
        20, exampleRangeThree.getLength(), .000000001d);
    }
    @Test
	public void centralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
				0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueTestOne() {
		assertEquals("getCentralValue class 1 test", 2.5, classOneRange.getCentralValue(), .000000001d);
	}

	@Test
	public void centralValueTestTwo() {
		assertEquals("getCentralValue class 2 test", 5, classTwoRange.getCentralValue(), .000000001d);
	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

