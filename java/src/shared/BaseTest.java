package shared;

public abstract class BaseTest implements TestCase {
  protected final TestReader testReader;
  
  protected BaseTest() {
    this.testReader = new TestReader(this.getClass());
  }

  protected void runTest(String testName, TestReader reader) {
    throw new UnsupportedOperationException("Must override either runTest() with two params");
  }

  @Override
  public void runTest(String testName) {
    try (testReader) {
      runTest(testName, testReader);
    }
  }

}
