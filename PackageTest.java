import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PackageTest
{
    private static Grader grader = new Grader("PackageTest", 42);
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }
    
    @Test
    public void testGetTrackingCode()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        final Package packageE;
        final Package packageF;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
        packageE = new Package(9999,  0.01,  "Kelowna",  "Prince George");
        packageF = new Package(99999, 99.99, "Victoria", "Richmond");
        
        assertEquals(123456789,  packageA.getTrackingCode());
        grader.addMark(1);
        assertEquals(12345690,   packageB.getTrackingCode());
        grader.addMark(1);
        assertEquals(0,          packageC.getTrackingCode());
        grader.addMark(1);
        assertEquals(1000000000, packageD.getTrackingCode());
        grader.addMark(1);
        assertEquals(9999,       packageE.getTrackingCode());
        grader.addMark(1);
        assertEquals(99999,      packageF.getTrackingCode());
        grader.addMark(1);
    }
    
    @Test
    public void testGetPriority()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
          
        assertEquals(1,   packageA.getPriority());
        grader.addMark(1);
        assertEquals(3,   packageB.getPriority());
        grader.addMark(1);
        assertEquals(2,   packageC.getPriority());
        grader.addMark(1);
        assertEquals(2,   packageD.getPriority());
        grader.addMark(1);
    }

    @Test
    public void testGetShippingPrice()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        final Package packageE;
        final Package packageF;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
        packageE = new Package(9999,  0.01,  "Kelowna",  "Prince George");
        packageF = new Package(99999, 99.99, "Victoria", "Richmond");
        
        assertEquals(5.60,     packageA.getShippingPrice(), 0.01);
        grader.addMark(1);
        assertEquals(100.99,   packageB.getShippingPrice(), 0.01);
        grader.addMark(1);
        assertEquals(9.98,     packageC.getShippingPrice(), 0.01);
        grader.addMark(1);
        assertEquals(2.01,     packageD.getShippingPrice(), 0.01);
        grader.addMark(1);
        assertEquals(0.01,     packageE.getShippingPrice(), 0.01);
        grader.addMark(1);
        assertEquals(99.99,    packageF.getShippingPrice(), 0.01);
        grader.addMark(1);
    }

    @Test
    public void testGetWeight()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
          
        assertEquals(0.0,    packageA.getWeight(), 0.01);
        grader.addMark(1);
        assertEquals(100.0,  packageB.getWeight(), 0.01);
        grader.addMark(1);
        assertEquals(10.0,   packageC.getWeight(), 0.01);
        grader.addMark(1);
        assertEquals(0.25,   packageD.getWeight(), 0.01);
        grader.addMark(1);
    }    
    
    @Test
    public void testOriginCity()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        final Package packageE;
        final Package packageF;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
        packageE = new Package(9999,  0.01,  "Kelowna",  "Prince George");
        packageF = new Package(99999, 99.99, "Victoria", "Richmond");
        
        assertEquals("Vancouver",  packageA.getOriginCity());
        grader.addMark(1);
        assertEquals("Vancouver",  packageB.getOriginCity());
        grader.addMark(1);
        assertEquals("Montreal",   packageC.getOriginCity());
        grader.addMark(1);
        assertEquals("Edmonton",   packageD.getOriginCity());
        grader.addMark(1);
        assertEquals("Kelowna",    packageE.getOriginCity());
        grader.addMark(1);
        assertEquals("Victoria",   packageF.getOriginCity());
        grader.addMark(1);
    }    
    
    @Test
    public void testDestinationCity()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        final Package packageE;
        final Package packageF;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
        packageE = new Package(9999,  0.01,  "Kelowna",  "Prince George");
        packageF = new Package(99999, 99.99, "Victoria", "Richmond");
        
        assertEquals("Toronto",  packageA.getDestCity());
        grader.addMark(1);
        assertEquals("Toronto",  packageB.getDestCity());
        grader.addMark(1);
        assertEquals("Ottawa",   packageC.getDestCity());
        grader.addMark(1);
        assertEquals("Calgary",   packageD.getDestCity());
        grader.addMark(1);
        assertEquals("Prince George",    packageE.getDestCity());
        grader.addMark(1);
        assertEquals("Richmond",   packageF.getDestCity());
        grader.addMark(1);
    }
    
    @Test
    public void testTrackingPage()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
          
        assertEquals("http://www.foo.com",          packageA.getTrackingPage());
        grader.addMark(1);
        assertEquals("https://www.foo.com",         packageB.getTrackingPage());
        grader.addMark(1);
        assertEquals("http://foo.com/bar",          packageC.getTrackingPage());
        grader.addMark(1);
        assertEquals("http://www.trackpackage.com", packageD.getTrackingPage());
        grader.addMark(1);
    }       
    
    @Test
    public void testGetPackageDetails()
    {
        final Package packageA;
        final Package packageB;
        final Package packageC;
        final Package packageD;
        final Package packageE;
        final Package packageF;
        
        packageA = new Package(123456789,  Package.MIN_PRIORITY, 5.60,   Package.MIN_WEIGHT,   "Vancouver", "Toronto", "http://www.foo.com");
        packageB = new Package(12345690,   Package.MAX_PRIORITY, 100.99, Package.MAX_WEIGHT,  "Vancouver", "Toronto", "https://www.foo.com");
        packageC = new Package(Package.MIN_TRACKING_CODE,   2, 9.98,   10.0,  "Montreal",  "Ottawa",  "http://foo.com/bar");
        packageD = new Package(Package.MAX_TRACKING_CODE,   2.01,  "Edmonton", "Calgary");
        packageE = new Package(9999,  0.01,  "Kelowna",  "Prince George");
        packageF = new Package(99999, 99.99, "Victoria", "Richmond");
        
        assertEquals("Package 123456789 ships from Vancouver to Toronto for $5.6 with priority 1 and weight of 0.0lbs. Tracking details at http://www.foo.com.",  
                     packageA.getPackageDetails());
        grader.addMark(1);
        assertEquals("Package 12345690 ships from Vancouver to Toronto for $100.99 with priority 3 and weight of 100.0lbs. Tracking details at https://www.foo.com.",  
                     packageB.getPackageDetails());
        grader.addMark(1);
        assertEquals("Package 0 ships from Montreal to Ottawa for $9.98 with priority 2 and weight of 10.0lbs. Tracking details at http://foo.com/bar.",  
                     packageC.getPackageDetails());
        grader.addMark(1);
        assertEquals("Package 1000000000 ships from Edmonton to Calgary for $2.01 with priority 2 and weight of 0.25lbs. Tracking details at http://www.trackpackage.com.",  
                     packageD.getPackageDetails());
        grader.addMark(1);
        assertEquals("Package 9999 ships from Kelowna to Prince George for $0.01 with priority 2 and weight of 0.25lbs. Tracking details at http://www.trackpackage.com.",  
                     packageE.getPackageDetails());
        grader.addMark(1);
        assertEquals("Package 99999 ships from Victoria to Richmond for $99.99 with priority 2 and weight of 0.25lbs. Tracking details at http://www.trackpackage.com.",  
                     packageF.getPackageDetails());
        grader.addMark(1);

    }
}
