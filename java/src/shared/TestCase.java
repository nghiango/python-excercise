package shared;

import java.io.File;

public interface TestCase {
  void runTest(String testName);

  default void runTest(int testNumber) {
    String testName = String.format("test_%s", testNumber);
    runTest(testName);
  }

  default void runAllTests() {
    String testDir = String.format("test/%s/", this.getClass().getSimpleName());
    File dir = new File(testDir);

    if (!dir.exists() || !dir.isDirectory()) {
      System.err.println("Test directory not found: " + testDir);
      return;
    }

    // Find all test files (files ending with .txt but not _output.txt)
    File[] testFiles = dir.listFiles((d, name) ->
        name.endsWith(".txt") && !name.endsWith("_output.txt"));

    if (testFiles == null || testFiles.length == 0) {
      System.out.println("No test files found in " + testDir);
      return;
    }

    System.out.println("Running " + testFiles.length + " test(s)...\n");
    // Run each test
    for (File testFile : testFiles) {
      String testName = testFile.getName().replaceFirst("[.][^.]*$", "");
      System.out.println("Running test: " + testName);
      runTest(testName);
    }
  };
}
