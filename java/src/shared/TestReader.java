package shared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestReader implements AutoCloseable {
  MyReader input;
  MyReader output;
  private final String className;

  public TestReader(Class clazz) {
    this.className = clazz.getSimpleName();
  }

  public MyReader readInput(int testNumber) {
    String testName = String.format("test_%s", testNumber);
    return readInput(testName);
  }

  public MyReader readInput(String testName) {
    String path = String.format("test/%s/%s.txt", className, testName);
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      input = new MyReader(reader);
      return input;
    } catch (IOException e) {
      throw new RuntimeException("Test file not found: " + path, e);
    }
  }

  public MyReader readOutput(int testNumber) {
    String testName = String.format("test_%s", testNumber);
    return readOutput(testName);
  }

  public MyReader readOutput(String testName) {
    String path = String.format("test/%s/%s_output.txt", className, testName);
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      output = new MyReader(reader);
      return output;
    } catch (IOException e) {
      throw new RuntimeException("Test file not found: " + path, e);
    }
  }

  @Override
  public void close() {
    if (input != null) input.close();
    if (output != null) output.close();
  }

}
