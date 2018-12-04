import org.junit.AfterClass;
import org.junit.Test;

public class PackageSpecificationTest
    extends SpecificationTest
{
    private static Grader grader = new Grader("PackageSpecificationTest", 25);
    private static Class<?> packageClass;
    
    static
    {
        try
        {
            packageClass = Class.forName("Package");
        }
        catch (ClassNotFoundException ex)
        {
            packageClass = null;
        }
    }
    
    @AfterClass
    public static void grade()
    {
        System.out.println("Score: " + grader.getTestName() + ": " + grader.getMarks() + " / " + grader.getMax());
    }

    @Test
    public void testMinTrackingCodeConstant()
    {
        testField(packageClass, "MIN_TRACKING_CODE", int.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }

    @Test
    public void testMaxTrackingCodeConstant()
    {
        testField(packageClass, "MAX_TRACKING_CODE", int.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }

    @Test
    public void testMinPriorityConstant()
    {
        testField(packageClass, "MIN_PRIORITY", int.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }

    @Test
    public void testMaxPriorityConstant()
    {
        testField(packageClass, "MAX_PRIORITY", int.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }
    
    @Test
    public void testMinShippingPriceConstant()
    {
        testField(packageClass, "MIN_SHIPPING_PRICE", double.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }
    
    @Test
    public void testMinWeightConstant()
    {
        testField(packageClass, "MIN_WEIGHT", double.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }    

    @Test
    public void testMaxWeightConstant()
    {
        testField(packageClass, "MAX_WEIGHT", double.class, new String[]
        {
            "public", 
            "static", 
            "final",
        }, new String[]
        {
        });
        grader.addMark(1);
    }     
    
    @Test
    public void testTrackingCode()
    {
        testField(packageClass, "trackingCode", int.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getTrackingCode", int.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testPriority()
    {
        testField(packageClass, "priority", int.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getPriority", int.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testShippingPrice()
    {
        testField(packageClass, "shippingPrice", double.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getShippingPrice", double.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testWeight()
    {
        testField(packageClass, "weight", double.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getWeight", double.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testOriginCity()
    {
        testField(packageClass, "originCity", String.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getOriginCity", String.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testDestinationCity()
    {
        testField(packageClass, "destCity", String.class, new String[]
        {
            "private",
        }, new String[]
        {
            "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getDestCity", String.class, new String[]
        {
            "public"
        }, new String[]
        {
            "static", "final"
        });
        grader.addMark(1);
    }
    
    @Test
    public void testTrackingPage()
    {
        testField(packageClass, "trackingPage", String.class, new String[]
        {
              "private",
        }, new String[]
        {
              "static",
        });
        grader.addMark(1);
        testMethod(packageClass, "getTrackingPage", String.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        });
        grader.addMark(1);
    }

    @Test
    public void testGetPackageDetails()
    {
        testMethod(packageClass, "getPackageDetails", String.class, new String[]
        {
               "public"
        }, new String[]
        {
               "static", "final"
        });
        grader.addMark(1);
    }
    
    @Test
    public void testConstructor()
    {
        testNumberOfConstructors(packageClass, 2);
        grader.addMark(1);
        testConstructor(packageClass, 
                        new String[]
                        {
                            "public",
                        },
                        new Class[]
                        {
                            int.class,
                            int.class,
                            double.class,
                            double.class,
                            String.class,
                            String.class,
                            String.class,
                        });
        grader.addMark(1);
        testConstructor(packageClass, 
                        new String[]
                        {
                            "public",
                        },
                        new Class[]
                        {
                            int.class,
                            double.class,
                            String.class,
                            String.class,
                        });
        grader.addMark(1);
    }
}
