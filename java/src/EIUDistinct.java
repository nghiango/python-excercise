import java.io.*;
import java.util.*;

public class EIUDistinct {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < T; t++) {
      String line = br.readLine().trim();
      String[] tokens = line.split("\\s+");

      int n = Integer.parseInt(tokens[0]); // first token = size
      TreeMap<Integer, Integer> map = new TreeMap<>();

      for (int i = 1; i <= n; i++) {
        int num = Integer.parseInt(tokens[i]);
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      // Output distinct numbers (value == 1) in ascending order
      boolean first = true;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
          if (!first) sb.append(' ');
          sb.append(entry.getKey());
          first = false;
        }
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }
}
