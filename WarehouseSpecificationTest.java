import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;

public class WarehouseSpecificationTest
    extends SpecificationTest
{
    private static Grader grader = new Grader("WarehouseSpecification", 11);
    private static Class<?> warehouseClass;
    
    static
    {
        try
        {
            warehouseClass = Class.forName("Warehouse");
        }
        catch (ClassNotFoundException ex)
        {
            warehouseClass = null;
        }
    }
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }

    @Test
    public void testPackages()
    {
        testField(warehouseClass, "packages", ArrayList.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
    }

    @Test
    public void testGetNumPackages()
    {
        testMethod(warehouseClass, "getNumPackages", int.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        });
        grader.addMark(1);
    }
    
    @Test
    public void testGetTotalPackageValue()
    {
        testMethod(warehouseClass, "getTotalPackageValue", double.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        });
        grader.addMark(1);
    }
    
    @Test
    public void testFindPackagesByPriority()
    {
        testMethod(warehouseClass, "findPackagesByPriority", Package[].class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        int.class);
        grader.addMark(1);
    }
    
    @Test
    public void testFindPackagesBelowWeight()
    {
        testMethod(warehouseClass, "findPackagesBelowWeight", Package[].class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        double.class);
        grader.addMark(1);
    }
    
    @Test
    public void testFindPackagesAboveWeight()
    {
        testMethod(warehouseClass, "findPackagesAboveWeight", Package[].class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        double.class);
        grader.addMark(1);
    }

    @Test
    public void testShipPackageByTrackingCode()
    {
        testMethod(warehouseClass, "shipPackageByTrackingCode", Package.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        int.class);
        grader.addMark(1);
    }
    
    @Test
    public void testShipPackagesByDestinationCity()
    {
        testMethod(warehouseClass, "shipPackagesByDestinationCity", Package[].class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        String.class);
        grader.addMark(1);
    }
    
    @Test
    public void testAddPackage()
    {
        testMethod(warehouseClass, "addPackage", void.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        },
        Package.class);
        grader.addMark(1);
    }
    
    @Test
    public void testConstructor()
    {
        testNumberOfConstructors(warehouseClass, 1);
        grader.addMark(1);
        testConstructor(warehouseClass, 
                        new String[]
                        {
                            "public",
                        },
                        new Class[]
                        {
                            Package[].class,
                        });
        grader.addMark(1);
    }
}
