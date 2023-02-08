package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRangeOne;
    private Range exampleRangeTwo;
    private Range exampleRangeThree;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRangeOne = new Range(-10, 10);
    	exampleRangeTwo = new Range(20, 50);
    	exampleRangeThree = new Range(-40, -20);
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
        20, exampleRangeTwo.getLength(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
