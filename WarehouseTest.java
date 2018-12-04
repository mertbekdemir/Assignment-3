import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class WarehouseTest
{
    private static Grader grader = new Grader("WarehouseTest", 41);
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }
    
    @Test
    public void testGetNumPackages()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Warehouse  warehouseA;
        final Warehouse  warehouseB;
        int total;
        
        packageA = new Package(123456780, 1, 1.5,  0.1, "A", "B", "http://a.com/B");
        packageB = new Package(123456781, 2, 1.75, 0.2, "A", "C", "http://a.com/C");
        packageC = new Package(123456782, 3, 2.0,  0.3, "D", "E", "http://a.com/E");
        warehouseA = new Warehouse(new Package[]
        {
            packageA,
        });
        warehouseB = new Warehouse(new Package[]
        {
            packageB,
            packageC,
        });
        
        assertEquals(1, warehouseA.getNumPackages());
        grader.addMark(1);
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);
    }    

    @Test
    public void testGetTotalPackageValue()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Warehouse  warehouseA;
        final Warehouse  warehouseB;
        final Warehouse  warehouseC;
        double total;
        
        packageA = new Package(123456780, 1, 1.5,  0.1, "A", "B", "http://a.com/B");
        packageB = new Package(123456781, 2, 1.75, 0.2, "A", "C", "http://a.com/C");
        packageC = new Package(123456782, 3, 2.0,  0.3, "D", "E", "http://a.com/E");
        warehouseA = new Warehouse(new Package[]
        {
        });
        warehouseB = new Warehouse(new Package[]
        {
            packageA,
        });
        warehouseC = new Warehouse(new Package[]
        {
            packageB,
            packageC,
        });
        
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(1, warehouseB.getNumPackages());
        assertEquals(2, warehouseC.getNumPackages());
        
        total = warehouseA.getTotalPackageValue(); 
        assertEquals(0.0, total, 0.0);
        grader.addMark(1);
        
        total = warehouseB.getTotalPackageValue(); 
        assertEquals(1.5, total, 0.0);
        grader.addMark(1);
        
        total = warehouseC.getTotalPackageValue(); 
        assertEquals(3.75, total, 0.0);
        grader.addMark(1);
    }

    @Test
    public void testFindPackagesByPriority()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Package    packageD;
        final Package    packageE;
        final Package    packageF;
        final Warehouse  warehouse;
        Package[]        packages;
        
        packageA = new Package(123456780, 1, 1.5,  0.1, "A", "B", "http://a.com/B");
        packageB = new Package(123456781, 2, 1.75, 0.2, "A", "C", "http://a.com/C");
        packageC = new Package(123456782, 3, 2.0,  0.3, "D", "E", "http://d.com/E");
        packageD = new Package(123456783, 2, 2.0,  0.3, "D", "E", "http://d.com/E");
        packageE = new Package(123456784, 3, 2.0,  0.3, "G", "F", "http://f.com/F");
        packageF = new Package(123456785, 3, 2.0,  0.3, "G", "F", "http://f.com/F");
        warehouse = new Warehouse(new Package[]
        {
            packageA,
            packageB,
            packageC,
            packageD,
            packageE,
            packageF,
        });
        
        try
        {
            warehouse.findPackagesByPriority(0);
            fail("findPackagesByPriority with a priority < 1 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Priority must be either 1, 2 or 3.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            warehouse.findPackagesByPriority(4);
            fail("findPackagesByPriority with a priority > 3 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Priority must be either 1, 2 or 3.", ex.getMessage());
            grader.addMark(1);
        }
        
        packages = warehouse.findPackagesByPriority(1);
        assertArrayEquals(new Package[]
        {
            packageA,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesByPriority(2);
        assertArrayEquals(new Package[]
        {
            packageB,
            packageD,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesByPriority(3);
        assertArrayEquals(new Package[]
        {
            packageC,
            packageE,
            packageF,
        }, packages);
        grader.addMark(1);
    }
    
    @Test
    public void testFindPackagesBelowWeight()
    {        
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Package    packageD;
        final Package    packageE;
        final Package    packageF;
        final Warehouse  warehouse;
        Package[]        packages;
        
        packageA = new Package(123456780, 1, 8.5,  61.5,  "A", "B", "http://a.com/B");
        packageB = new Package(123456781, 2, 1.75, 0.01,  "A", "C", "http://a.com/C");
        packageC = new Package(123456782, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        packageD = new Package(123456783, 2, 9.0,  100.0, "D", "E", "http://d.com/E");
        packageE = new Package(123456784, 3, 5.75, 50.5,  "G", "F", "http://f.com/F");
        packageF = new Package(123456785, 3, 2.0,  2.0,   "G", "F", "http://f.com/F");
        warehouse = new Warehouse(new Package[]
        {
            packageA,
            packageB,
            packageC,
            packageD,
            packageE,
            packageF,
        });
        
        try
        {
            warehouse.findPackagesBelowWeight(-0.01);
            fail("findPackagesBelowWeight with a weight < 0.0 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            warehouse.findPackagesBelowWeight(100.01);
            fail("findPackagesBelowWeight with a weight < 0.0 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
        
        packages = warehouse.findPackagesBelowWeight(2.6);
        assertArrayEquals(new Package[]
        {
            packageB,
            packageC,
            packageF,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesBelowWeight(2.5);
        assertArrayEquals(new Package[]
        {
            packageB,
            packageF,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesBelowWeight(61.4);
        assertArrayEquals(new Package[]
        {
            packageB,
            packageC,
            packageE,
            packageF,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesBelowWeight(100.0);
        assertArrayEquals(new Package[]
        {
            packageA,
            packageB,
            packageC,
            packageE,
            packageF,
        }, packages);
        grader.addMark(1);
    }
    
    @Test
    public void testFindPackagesAboveWeight()
    {        
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Package    packageD;
        final Package    packageE;
        final Package    packageF;
        final Warehouse  warehouse;
        Package[]        packages;
        
        packageA  = new Package(123456780, 1, 8.5,  61.5,  "A", "B", "http://a.com/B");
        packageB  = new Package(123456781, 2, 1.75, 0.01,  "A", "C", "http://a.com/C");
        packageC  = new Package(123456782, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        packageD  = new Package(123456783, 2, 9.0,  100.0, "D", "E", "http://d.com/E");
        packageE  = new Package(123456784, 3, 5.75, 50.5,  "G", "F", "http://f.com/F");
        packageF  = new Package(123456785, 3, 2.0,  2.0,   "G", "F", "http://f.com/F");
        warehouse = new Warehouse(new Package[]
        {
            packageA,
            packageB,
            packageC,
            packageD,
            packageE,
            packageF,
        });
        
        try
        {
            warehouse.findPackagesAboveWeight(-0.01);
            fail("findPackagesAboveWeight with a weight < 0.0 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            warehouse.findPackagesAboveWeight(100.01);
            fail("findPackagesAboveWeight with a weight < 0.0 must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Weight must be between 0.0 and 100.0lbs.", ex.getMessage());
            grader.addMark(1);
        }
        
        packages = warehouse.findPackagesAboveWeight(2.6);
        assertArrayEquals(new Package[]
        {
            packageA,
            packageD,
            packageE,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesAboveWeight(2.5);
        assertArrayEquals(new Package[]
        {
            packageA,
            packageD,
            packageE,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesAboveWeight(61.4);
        assertArrayEquals(new Package[]
        {
            packageA,
            packageD,
        }, packages);
        grader.addMark(1);
        
        packages = warehouse.findPackagesAboveWeight(0.0);
        assertArrayEquals(new Package[]
        {
            packageA,
            packageB,
            packageC,
            packageD,
            packageE,
            packageF,
        }, packages);
        grader.addMark(1);
    }
    
    @Test
    public void testAddPackage()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Package    packageD;
        final Warehouse  warehouseA;
        final Warehouse  warehouseB;
        final Warehouse  warehouseC;
        Package[]        packages;
        
        packageA  = new Package(123456780, 1, 8.5,  61.5,  "A", "B", "http://a.com/B");
        packageB  = new Package(123456781, 2, 1.75, 0.01,  "A", "C", "http://a.com/C");
        packageC  = new Package(123456782, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        packageD  = new Package(123456782, 2, 9.0,  100.0, "D", "E", "http://d.com/E");
        warehouseA = new Warehouse(new Package[]
        {
        });
        
        assertEquals(0, warehouseA.getNumPackages());
        warehouseA.addPackage(packageA);
        assertEquals(1, warehouseA.getNumPackages());
        warehouseA.addPackage(packageB);
        assertEquals(2, warehouseA.getNumPackages());
        warehouseA.addPackage(packageC);
        assertEquals(3, warehouseA.getNumPackages());
        
        try
        {
            warehouseA.addPackage(packageD);
            fail("add with a duplicate tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Tracking Code is not unique.", ex.getMessage());
            grader.addMark(1);
        }
        
        assertEquals(3, warehouseA.getNumPackages());

        warehouseB = new Warehouse(new Package[]
        {
        });
        
        warehouseC = new Warehouse(new Package[]
        {
        });
        
        assertEquals(0, warehouseB.getNumPackages());
        assertEquals(0, warehouseC.getNumPackages());

        warehouseB.addPackage(packageB);
        assertEquals(1, warehouseB.getNumPackages());
        assertEquals(0, warehouseC.getNumPackages());
        grader.addMark(1);

        warehouseB.addPackage(packageA);
        assertEquals(2, warehouseB.getNumPackages());
        assertEquals(0, warehouseC.getNumPackages());
        grader.addMark(1);

        warehouseC.addPackage(packageC);
        assertEquals(2, warehouseB.getNumPackages());
        assertEquals(1, warehouseC.getNumPackages());
        grader.addMark(1);        
    }

    @Test
    public void testShipPackageByTrackingCode()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Warehouse  warehouseA;
        final Warehouse  warehouseB;
        Package          shipped;
        
        packageA  = new Package(123456780, 1, 8.5,  61.5,  "A", "B", "http://a.com/B");
        packageB  = new Package(123456781, 2, 1.75, 0.01,  "A", "C", "http://a.com/C");
        packageC  = new Package(123456782, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        warehouseA = new Warehouse(new Package[]
        {
            packageA,
        });
        
        warehouseB = new Warehouse(new Package[]
        {
            packageB,
            packageC
        });
        
        try
        {
            warehouseA.shipPackageByTrackingCode(-1);
            fail("ship with bad tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Sorry, tracking code -1 cannot be negative.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            warehouseA.shipPackageByTrackingCode(1000000001);
            fail("sell with a bad tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("Sorry, tracking code 1000000001 is too large.", ex.getMessage());
            grader.addMark(1);
        }
        
        assertEquals(1, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        
        shipped = warehouseA.shipPackageByTrackingCode(1000);
        assertNull(shipped);
        assertEquals(1, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);
        
        shipped = warehouseA.shipPackageByTrackingCode(123456780);
        assertNotNull(shipped);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);

        shipped = warehouseB.shipPackageByTrackingCode(1000);
        assertNull(shipped);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);
        
        shipped = warehouseB.shipPackageByTrackingCode(123456781);
        assertNotNull(shipped);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(1, warehouseB.getNumPackages());
        grader.addMark(1);

        shipped = warehouseB.shipPackageByTrackingCode(123456782);
        assertNotNull(shipped);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(0, warehouseB.getNumPackages());
        grader.addMark(1);

        shipped = warehouseB.shipPackageByTrackingCode(123456782);
        assertNull(shipped);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(0, warehouseB.getNumPackages());
        grader.addMark(1);
    }
    
    @Test
    public void testShipPackagesByDestinationCity()
    {
        final Package    packageA;
        final Package    packageB;
        final Package    packageC;
        final Package    packageD;
        final Warehouse  warehouseA;
        final Warehouse  warehouseB;
        Package[]        shipped;
        
        packageA  = new Package(123456780, 1, 8.5,  61.5,  "A", "B", "http://a.com/B");
        packageB  = new Package(123456781, 2, 1.75, 0.01,  "A", "C", "http://a.com/C");
        packageC  = new Package(123456782, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        packageD  = new Package(123456783, 3, 2.0,  2.5,   "D", "E", "http://d.com/E");
        warehouseA = new Warehouse(new Package[]
        {
            packageA,
            packageB,
        });
        
        warehouseB = new Warehouse(new Package[]
        {
            packageC,
            packageD,
        });
        
        try
        {
            warehouseA.shipPackagesByDestinationCity(null);
            fail("ship with bad tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Destination City is not valid.", ex.getMessage());
            grader.addMark(1);
        }
        
        try
        {
            warehouseA.shipPackagesByDestinationCity("");
            fail("sell with a bad tracking code must throw an IllegalArgumentException");
        }
        catch(final IllegalArgumentException ex)
        {
            assertEquals("The Destination City is not set.", ex.getMessage());
            grader.addMark(1);
        }
        
        assertEquals(2, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        
        shipped = warehouseA.shipPackagesByDestinationCity("BadCity");
        assertEquals(0, shipped.length);
        assertEquals(2, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);
        
        shipped = warehouseA.shipPackagesByDestinationCity("B");
        assertEquals(1, shipped.length);
        assertEquals(1, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);

        shipped = warehouseA.shipPackagesByDestinationCity("C");
        assertEquals(1, shipped.length);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(2, warehouseB.getNumPackages());
        grader.addMark(1);
        
        shipped = warehouseB.shipPackagesByDestinationCity("E");
        assertEquals(2, shipped.length);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(0, warehouseB.getNumPackages());
        grader.addMark(1);

        shipped = warehouseB.shipPackagesByDestinationCity("E");
        assertEquals(0, shipped.length);
        assertEquals(0, warehouseA.getNumPackages());
        assertEquals(0, warehouseB.getNumPackages());
        grader.addMark(1);
    }    
}
