import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PackageConstructorTest
{
    private static Grader grader = new Grader("PackageConstructorTest", 19);
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }
    
    @Test
    public void testMinTrackingCodeConstant()
    {
        assertEquals(0, Package.MIN_TRACKING_CODE);
        grader.addMark(1);
    }

    @Test
    public void testMaxTrackingCodeConstant()
    {
        assertEquals(1000000000, Package.MAX_TRACKING_CODE);
        grader.addMark(1);
    }

    @Test
    public void testMinShippingPriceConstant()
    {
        assertEquals(0.0, Package.MIN_SHIPPING_PRICE, 0.01);
        grader.addMark(1);
    }

    @Test
    public void testMinWeightConstant()
    {
        assertEquals(0.0, Package.MIN_WEIGHT, 0.01);
        grader.addMark(1);
    }
    
    @Test
    public void testMaxWeightConstant()
    {
        assertEquals(100.0, Package.MAX_WEIGHT, 0.01);
        grader.addMark(1);
    }
    
    @Test
    public void testBadTrackingCode()
    {
        try
        {
            new Package(-1,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("negative tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Sorry, tracking code cannot be negative.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(1000000001,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("too big tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Sorry, tracking code 1000000001 is too large.", ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void testBadPriority()
    {
        try
        {
            new Package(9999,  -1, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("negative priority must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Priority must be either 1, 2 or 3.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  4, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("to large priority must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Priority must be either 1, 2 or 3.", ex.getMessage());
            grader.addMark(1);
        }
    }
    
    @Test
    public void testBadShippingPrice()
    {
        try
        {
            new Package(9999,  2, -0.01,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("negative shipping price must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Shipping Price cannot be negative.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  2, -10.0,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("negative shipping price must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Shipping Price cannot be negative.", ex.getMessage());
            grader.addMark(1);
        }
    }
    
    @Test
    public void testBadWeight()
    {
        try
        {
            new Package(9999,  2, 5.5,   -0.01,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("negative weight must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  2, 5.5,   100.01,   "Vancouver", "Toronto", "http://www.foo.com");
            fail("too large a weight must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
    }
     
    @Test
    public void testBadOriginCity()
    {
        try
        {
            new Package(9999,  2, 5.5,   0.5,   null, "Toronto", "http://www.foo.com");
            fail("null origin city must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Origin City is not valid.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  2, 5.5,   0.5,   "", "Toronto", "http://www.foo.com");
            fail("empty origin city must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Origin City is not set.", ex.getMessage());
            grader.addMark(1);
        }
    }
    
    @Test
    public void testBadDestCity()
    {
        try
        {
            new Package(9999,  2, 5.5,   0.5,   "Ottawa", null, "http://www.foo.com");
            fail("null origin city must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Destination City is not valid.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  2, 5.5,   0.5,   "Ottawa", "", "http://www.foo.com");
            fail("empty origin city must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Destination City is not set.", ex.getMessage());
            grader.addMark(1);
        }
    }
 
    @Test
    public void testBadTrackingPage()
    {
        try
        {
            new Package(9999,  2, 5.5,   0.5,   "Ottawa", "Toronto", null);
            fail("null tracking page must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Tracking Page is not valid.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Package(9999,  2, 5.5,   0.5,   "Ottawa", "Toronto", "");
            fail("empty tracking page must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Tracking Page is not set.", ex.getMessage());
            grader.addMark(1);
        }
    }
}
