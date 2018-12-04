import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  PackageSpecificationTest.class,
  WarehouseSpecificationTest.class,
  JavadocTest.class,
  PackageConstructorTest.class,
  PackageTest.class,
  WarehouseConstructorTest.class,
  WarehouseTest.class,
})

public class PackageTestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}