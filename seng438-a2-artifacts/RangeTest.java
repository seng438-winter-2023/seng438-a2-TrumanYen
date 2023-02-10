package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.junit.*;
import org.jmock.*;
import org.jfree.data.*;


public class RangeTest{

	private Range exampleRange;
	private Range classOneRange;
	private Range classTwoRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);

		// how many equivalence classes?
		// for each double input:
		// no restriction on double input
		// equivalence classes will be:
		// class 1: lb < ub
		// class 2: lb = ub
		// class 3: lb > ub throws error

		classOneRange = new Range(0, 5);
		classTwoRange = new Range(5, 5);
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
		assertEquals("getCentralValue class 2 test", 5, classOneRange.getCentralValue(), .000000001d);
	}
    
    
	  @Test
	  public void calculateColumnTotalForTwoValues() {
	      // setup
	  Mockery mockingContext = new Mockery();
	  final Values2D values = mockingContext.mock(Values2D.class);
	  mockingContext.checking(new Expectations() {
	      {
	          one(values).getRowCount();
	          will(returnValue(2));
	          one(values).getValue(0, 0);
	          will(returnValue(7.5));
	          one(values).getValue(1, 0);
	          will(returnValue(2.5));
	      }
	  });
	  double result = DataUtilities.calculateColumnTotal(values, 0);
	  // verify
	  assertEquals(result, 10.0, .000000001d);
	  // tear-down: NONE in this test method
	  }
	  
	  @Test
	  public void calculateRowTotalForTwoValues() {
	      // setup
	  Mockery mockingContext = new Mockery();
	  final Values2D values = mockingContext.mock(Values2D.class);
	  mockingContext.checking(new Expectations() {
	      {
	          one(values).getColumnCount();
	          will(returnValue(2));
	          one(values).getValue(0, 0);
	          will(returnValue(6));
	          one(values).getValue(0, 1);
	          will(returnValue(4));
	      }
	  });
	  double result = DataUtilities.calculateRowTotal(values, 0);
	  // verify
	  assertEquals(10.0, result, .000000001d);
	  // tear-down: NONE in this test method
	  }
	  
	  @Test
	  public void createNumberArrayWithPositiveDoubles() {
	      // setup
		  
		  double[] testPositive = new double[] {3.0, 6.0, 9.0};
		  
	  final java.lang.Number[] expected = new java.lang.Number[] {3.0, 6.0, 9.0};
	  
	  
	  java.lang.Number[] result = DataUtilities.createNumberArray(testPositive);
	  // verify
	  assertEquals(expected, result);
	  // tear-down: NONE in this test method
	  }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
