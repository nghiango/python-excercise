package shared;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class AssertUtils {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void printError(Object actual, Object expected) {
    System.out.println(ANSI_RED + "Expected: " + toString(expected) + ", but was: " + toString(actual) + ANSI_RESET);
  }

  public static void assertEquals(Object actual, Object expected) {
    if (!areEqual(actual, expected)) {
      printError(actual, expected);
      throw new AssertionError("Test failed");
    } else {
      System.out.println(ANSI_GREEN + "✓ PASSED" + ANSI_RESET);
    }
  }

  private static boolean areEqual(Object actual, Object expected) {
    if (actual == expected)
      return true;
    if (actual == null || expected == null)
      return false;

    // Handle Collection vs Array comparison
    if (actual instanceof Collection && expected.getClass().isArray()) {
      return collectionEqualsArray((Collection<?>) actual, expected);
    }
    if (actual.getClass().isArray() && expected instanceof Collection) {
      return collectionEqualsArray((Collection<?>) expected, actual);
    }

    if (actual.getClass().isArray() && expected.getClass().isArray()) {
      return arrayEquals(actual, expected);
    }
    return Objects.equals(actual, expected);
  }

  private static boolean arrayEquals(Object array1, Object array2) {
    if (array1 == array2)
      return true;
    if (array1 == null || array2 == null)
      return false;

    int length1 = java.lang.reflect.Array.getLength(array1);
    int length2 = java.lang.reflect.Array.getLength(array2);
    if (length1 != length2)
      return false;

    for (int i = 0; i < length1; i++) {
      Object o1 = java.lang.reflect.Array.get(array1, i);
      Object o2 = java.lang.reflect.Array.get(array2, i);
      if (!Objects.equals(o1, o2))
        return false;
    }
    return true;
  }

  private static boolean collectionEqualsArray(Collection<?> collection, Object array) {
    if (collection == null || array == null)
      return false;

    int arrayLength = java.lang.reflect.Array.getLength(array);
    if (collection.size() != arrayLength)
      return false;

    int index = 0;
    for (Object collectionElement : collection) {
      Object arrayElement = java.lang.reflect.Array.get(array, index);
      if (!Objects.equals(collectionElement, arrayElement))
        return false;
      index++;
    }
    return true;
  }

  private static String toString(Object obj) {
    if (obj == null)
      return "null";
    if (obj.getClass().isArray()) {
      if (obj instanceof int[])
        return Arrays.toString((int[]) obj);
      if (obj instanceof long[])
        return Arrays.toString((long[]) obj);
      if (obj instanceof boolean[])
        return Arrays.toString((boolean[]) obj);
      if (obj instanceof char[])
        return Arrays.toString((char[]) obj);
      if (obj instanceof byte[])
        return Arrays.toString((byte[]) obj);
      if (obj instanceof short[])
        return Arrays.toString((short[]) obj);
      if (obj instanceof float[])
        return Arrays.toString((float[]) obj);
      if (obj instanceof double[])
        return Arrays.toString((double[]) obj);
      return Arrays.deepToString((Object[]) obj);
    }
    return obj.toString();
  }
}
