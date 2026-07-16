package shared;

import java.io.BufferedReader;
import java.io.IOException;

public class MyReader implements AutoCloseable {
  private final BufferedReader reader;

  /**
   * Constructs a reader from a BufferedReader.
   * Example: new MyReader(new BufferedReader(new FileReader("test.txt")))
   */
  public MyReader(BufferedReader reader) {
    this.reader = reader;
  }

  /**
   * Reads a single line as a raw string.
   * Example input: "hello world"
   */
  public String nextLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException("Error reading line", e);
    }
  }

  /**
   * Reads a single line array as strings.
   * Example input: ["a", "b", "c"]
   */
  public String[] nextLineArray() {
    return nextLineArray(String[].class);
  }

  /**
   * Reads a single line array as the requested type.
   * Example inputs:
   *   ["a", "b", "c"]  -> String[]
   *   [1, 2, 3]        -> int[]
   *   [true, false]    -> Boolean[]
   */
  @SuppressWarnings("unchecked")
  public <T> T nextLineArray(Class<T> type) {
    try {
      String line = reader.readLine().trim();
      if (line.startsWith("[") && line.endsWith("]")) {
        line = line.substring(1, line.length() - 1);
      }
      if (line.isEmpty()) {
        if (type == String[].class) return (T) new String[0];
        if (type == int[].class) return (T) new int[0];
        if (type == Integer[].class) return (T) new Integer[0];
        if (type == Long[].class) return (T) new Long[0];
        if (type == Boolean[].class) return (T) new Boolean[0];
        throw new UnsupportedOperationException("Unsupported type: " + type.getSimpleName());
      }
      String[] stringArray = line.split(",");
      if (type == String[].class) {
        for (int i = 0; i < stringArray.length; i++) {
          String token = stringArray[i].trim();
          if (token.startsWith("\"") && token.endsWith("\"")) {
            stringArray[i] = token.substring(1, token.length() - 1);
          } else {
            stringArray[i] = token;
          }
        }
        return (T) stringArray;
      } else if (type == int[].class) {
        int[] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
          result[i] = Integer.parseInt(stringArray[i].trim());
        }
        return (T) result;
      } else if (type == Integer[].class) {
        Integer[] result = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
          result[i] = Integer.parseInt(stringArray[i].trim());
        }
        return (T) result;
      } else if (type == Long[].class) {
        Long[] result = new Long[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
          result[i] = Long.parseLong(stringArray[i].trim());
        }
        return (T) result;
      } else if (type == Boolean[].class) {
        Boolean[] result = new Boolean[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
          String token = stringArray[i].trim();
          result[i] = token.equals("null") ? null : Boolean.parseBoolean(token);
        }
        return (T) result;
      } else {
        throw new UnsupportedOperationException("Unsupported type: " + type.getSimpleName());
      }
    } catch (IOException e) {
      throw new RuntimeException("Error reading line", e);
    } catch (NumberFormatException e) {
      throw new RuntimeException("Error parsing array element", e);
    }
  }

  /**
   * Reads a single line containing an array of string arrays.
   * Example input: [["a","b"], [], ["c"]]
   */
  public String[][] nextLineArrayOfArrays() {
    try {
      String line = reader.readLine().trim();
      if (line.startsWith("[[") && line.endsWith("]")) {
        line = line.substring(1, line.length() - 1).trim();
      }
      java.util.List<String[]> result = new java.util.ArrayList<>();
      int i = 0;
      while (i < line.length()) {
        int open = line.indexOf('[', i);
        if (open == -1) break;
        int close = line.indexOf(']', open);
        if (close == -1) break;
        String inner = line.substring(open + 1, close).trim();
        if (inner.isEmpty()) {
          result.add(new String[0]);
        } else {
          java.util.List<String> items = new java.util.ArrayList<>();
          java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(inner);
          if (m.find()) {
            items.add(m.group(1));
            while (m.find()) {
              items.add(m.group(1));
            }
          } else {
            for (String token : inner.split(",")) {
              items.add(token.trim());
            }
          }
          result.add(items.toArray(new String[0]));
        }
        i = close + 1;
      }
      return result.toArray(new String[0][]);
    } catch (IOException e) {
      throw new RuntimeException("Error reading line", e);
    }
  }

  /**
   * Reads a single integer value.
   * Example input: 42
   */
  public int nextInt() {
    try {
      String line = reader.readLine();
      return Integer.parseInt(line.trim());
    } catch (IOException e) {
      throw new RuntimeException("Error reading integer", e);
    } catch (NumberFormatException e) {
      throw new RuntimeException("Invalid integer format", e);
    }
  }

  /**
   * Reads a single long value.
   * Example input: 9223372036854775807
   */
  public long nextLong() {
    try {
      String line = reader.readLine();
      return Long.parseLong(line.trim());
    } catch (IOException e) {
      throw new RuntimeException("Error reading long", e);
    } catch (NumberFormatException e) {
      throw new RuntimeException("Invalid long format", e);
    }
  }

  /**
   * Reads a single double value.
   * Example input: 3.14
   */
  public double nextDouble() {
    try {
      String line = reader.readLine();
      return Double.parseDouble(line.trim());
    } catch (IOException e) {
      throw new RuntimeException("Error reading double", e);
    } catch (NumberFormatException e) {
      throw new RuntimeException("Invalid double format", e);
    }
  }

  /**
   * Reads a single boolean value.
   * Example input: true
   */
  public boolean nextBoolean() {
    try {
      String line = reader.readLine();
      return Boolean.parseBoolean(line.trim());
    } catch (IOException e) {
      throw new RuntimeException("Error reading boolean", e);
    }
  }

  /**
   * Gateway method that reads the next input using the correct parser for the requested type.
   * Examples:
   *   char[][] board = reader.nextInput(char[][].class);
   *   int[] nums     = reader.nextInput(int[].class);
   *   String word    = reader.nextInput(String.class);
   *   int k          = reader.nextInput(int.class);
   *   boolean ok     = reader.nextInput(boolean.class);
   */
  @SuppressWarnings("unchecked")
  public <T> T nextInput(Class<T> type) {
    if (type == String.class) {
      return (T) nextLine();
    } else if (type == int.class || type == Integer.class) {
      return (T) Integer.valueOf(nextInt());
    } else if (type == long.class || type == Long.class) {
      return (T) Long.valueOf(nextLong());
    } else if (type == double.class || type == Double.class) {
      return (T) Double.valueOf(nextDouble());
    } else if (type == boolean.class || type == Boolean.class) {
      return (T) Boolean.valueOf(nextBoolean());
    } else if (type.isArray()) {
      if (type.getComponentType().isArray()) {
        return next2DArrayInline(type);
      } else {
        return nextLineArray(type);
      }
    }
    throw new UnsupportedOperationException("Unsupported type: " + type.getSimpleName());
  }

  /**
   * Reads multiple lines and returns a 2D array.
   * Each line should contain comma-separated values.
   * Reads until an empty line or EOF is encountered.
   * Example input:
   *   1,2,3
   *   4,5,6
   *   -> int[][] {{1,2,3},{4,5,6}}
   *
   * @param type The component type of the 2D array (e.g., int[][].class, String[][].class)
   * @return A 2D array of the specified type
   */
  @SuppressWarnings("unchecked")
  public <T> T next2DArray(Class<T> type) {
    java.util.List<Object> rows = new java.util.ArrayList<>();
    
    // Determine the component type (1D array type)
    Class<?> componentType = getComponentType(type);
    
    // Read lines until empty line or EOF
    while (hasNextLine()) {
      // Peek at the next line to check if it's empty
      try {
        reader.mark(1000);
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) {
          break;
        }
        reader.reset();
      } catch (IOException e) {
        throw new RuntimeException("Error reading 2D array", e);
      }
      
      rows.add(nextLineArray(componentType));
    }
    
    if (rows.isEmpty()) {
      throw new RuntimeException("No data to read for 2D array");
    }
    
    return convertTo2DArray(rows, type);
  }
  
  /**
   * Reads a specific number of lines and returns a 2D array.
   * Each line should contain comma-separated values.
   * Example input (numRows=2):
   *   1,2,3
   *   4,5,6
   *   -> int[][] {{1,2,3},{4,5,6}}
   *
   * @param type The component type of the 2D array (e.g., int[][].class, String[][].class)
   * @param numRows The number of rows to read
   * @return A 2D array of the specified type
   */
  @SuppressWarnings("unchecked")
  public <T> T next2DArray(Class<T> type, int numRows) {
    java.util.List<Object> rows = new java.util.ArrayList<>();
    
    // Determine the component type (1D array type)
    Class<?> componentType = getComponentType(type);
    
    // Read exactly numRows lines
    for (int i = 0; i < numRows; i++) {
      rows.add(nextLineArray(componentType));
    }
    
    return convertTo2DArray(rows, type);
  }
  
  /**
   * Reads a single line (or multi-line) containing all rows inline.
   * Example inputs:
   *   [["a","b"],["c","d"]]                  -> String[][]
   *   [["5","3","."],["6",".","."],...]      -> char[][]
   */
  @SuppressWarnings("unchecked")
  public <T> T next2DArrayInline(Class<T> type) {
    try {
      String line = readInlineArrayText();
      if (line.startsWith("[") && line.endsWith("]")) {
        line = line.substring(1, line.length() - 1).trim();
      }
      java.util.List<Object> rows = new java.util.ArrayList<>();
      int i = 0;
      while (i < line.length()) {
        int open = line.indexOf('[', i);
        if (open == -1) break;
        int close = line.indexOf(']', open);
        if (close == -1) break;
        String inner = line.substring(open + 1, close).trim();
        rows.add(parseInlineRow(inner, type));
        i = close + 1;
      }
      return convertTo2DArray(rows, type);
    } catch (IOException e) {
      throw new RuntimeException("Error reading inline 2D array", e);
    }
  }

  private String readInlineArrayText() throws IOException {
    StringBuilder builder = new StringBuilder();
    int balance = 0;
    boolean started = false;
    while (true) {
      String line = reader.readLine();
      if (line == null) break;
      String trimmed = line.trim();
      if (trimmed.isEmpty() && !started) continue;
      if (builder.length() > 0) builder.append(' ');
      builder.append(trimmed);
      for (int i = 0; i < trimmed.length(); i++) {
        char current = trimmed.charAt(i);
        if (current == '[') {
          balance++;
          started = true;
        } else if (current == ']') {
          balance--;
        }
      }
      if (started && balance <= 0) break;
    }
    return builder.toString().trim();
  }

  private Object parseInlineRow(String inner, Class<?> type) {
    if (inner.isEmpty()) {
      if (type == char[][].class) return new char[0];
      if (type == String[][].class) return new String[0];
      if (type == int[][].class) return new int[0];
      return new String[0];
    }
    java.util.List<String> tokens = new java.util.ArrayList<>();
    java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(inner);
    if (m.find()) {
      tokens.add(m.group(1));
      while (m.find()) tokens.add(m.group(1));
    } else {
      for (String t : inner.split(",")) tokens.add(t.trim());
    }
    if (type == char[][].class) {
      char[] row = new char[tokens.size()];
      for (int i = 0; i < tokens.size(); i++) row[i] = tokens.get(i).charAt(0);
      return row;
    } else if (type == int[][].class) {
      int[] row = new int[tokens.size()];
      for (int i = 0; i < tokens.size(); i++) row[i] = Integer.parseInt(tokens.get(i));
      return row;
    } else {
      return tokens.toArray(new String[0]);
    }
  }

  /**
   * Helper method to get the component type of a 2D array.
   */
  private Class<?> getComponentType(Class<?> type) {
    if (type == int[][].class) {
      return int[].class;
    } else if (type == Integer[][].class) {
      return Integer[].class;
    } else if (type == String[][].class) {
      return String[].class;
    } else if (type == Long[][].class) {
      return Long[].class;
    } else if (type == double[][].class) {
      return double[].class;
    } else if (type == Double[][].class) {
      return Double[].class;
    } else if (type == char[][].class) {
      return char[].class;
    } else {
      throw new UnsupportedOperationException("Unsupported 2D array type: " + type.getSimpleName());
    }
  }
  
  /**
   * Helper method to convert a list of 1D arrays to a 2D array.
   */
  @SuppressWarnings("unchecked")
  private <T> T convertTo2DArray(java.util.List<Object> rows, Class<T> type) {
    if (type == int[][].class) {
      int[][] result = new int[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (int[]) rows.get(i);
      }
      return (T) result;
    } else if (type == Integer[][].class) {
      Integer[][] result = new Integer[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (Integer[]) rows.get(i);
      }
      return (T) result;
    } else if (type == String[][].class) {
      String[][] result = new String[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (String[]) rows.get(i);
      }
      return (T) result;
    } else if (type == Long[][].class) {
      Long[][] result = new Long[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (Long[]) rows.get(i);
      }
      return (T) result;
    } else if (type == double[][].class) {
      double[][] result = new double[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (double[]) rows.get(i);
      }
      return (T) result;
    } else if (type == Double[][].class) {
      Double[][] result = new Double[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (Double[]) rows.get(i);
      }
      return (T) result;
    } else if (type == char[][].class) {
      char[][] result = new char[rows.size()][];
      for (int i = 0; i < rows.size(); i++) {
        result[i] = (char[]) rows.get(i);
      }
      return (T) result;
    } else {
      throw new UnsupportedOperationException("Unsupported 2D array type: " + type.getSimpleName());
    }
  }

  /**
   * Checks if there is more input to read.
   * Example: while (reader.hasNextLine()) { ... }
   */
  public boolean hasNextLine() {
    try {
      reader.mark(1);
      boolean hasNext = reader.read() != -1;
      reader.reset();
      return hasNext;
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * Closes the underlying reader.
   * Example: try (MyReader reader = new MyReader(...)) { ... }
   */
  @Override
  public void close() {
    try {
      if (reader != null) {
        reader.close();
      }
    } catch (IOException e) {
      throw new RuntimeException("Error closing reader", e);
    }
  }
}
