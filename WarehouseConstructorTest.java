import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WarehouseConstructorTest
{
    private static Grader grader = new Grader("WarehouseConstructorTest", 4);
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }
    
    @Test
    public void testNullPackages()
    {
        try
        {
            new Warehouse(null);
            fail("null packages must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("List of Packages cannot be null.", ex.getMessage());
            grader.addMark(1);
        }
    }
    
    @Test
    public void testDuplicateTrackingCodes()
    {
        try
        {
            new Warehouse(new Package[]
            {
                new Package(123456780, 1, 1.0, 1.0, "A", "B", "http://a.com/B"),
                new Package(123456781, 1, 1.0, 1.0, "C", "D", "http://c.com/D"),
                new Package(123456780, 1, 1.0, 1.0, "E", "F", "http://r.com/F"),
            });
            fail("warehouses with a duplicate tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Duplicate Tracking Code found: 123456780", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            new Warehouse(new Package[]
            {
                new Package(123456780, 2, 2.0, 2.0, "A", "B", "http://a.com/B"),
                new Package(123456781, 2, 2.0, 2.0, "A", "C", "http://a.com/C"),
                new Package(123456781, 2, 2.0, 2.0, "A", "D", "http://a.com/D"),
            });
            fail("warehouses with a duplicate tracking codes must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Duplicate Tracking Code found: 123456781", ex.getMessage());
            grader.addMark(1);
        }
    }
    
    @Test
    public void testValidConstructor()
    {
        new Warehouse(new Package[]
        {
        });
        grader.addMark(1);
        
        new Warehouse(new Package[]
        {
            new Package(123456789, 2, 2.50, 0.5, "A", "B", "http://a.com/B"),
        });
        
        new Warehouse(new Package[]
        {
            new Package(123456781, 2, 2.50, 0.5, "A", "B", "http://a.com/B"),
            new Package(123456782, 2, 2.50, 0.5, "A", "C", "http://a.com/C"),
            new Package(123456783, 2, 2.50, 0.5, "A", "D", "http://a.com/D"),
        });
    }
}
