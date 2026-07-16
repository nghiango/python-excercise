import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    calculateDistance();
  }

  private static void calculate() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long sum = 0;
    long totalDeposit = 0;
    long failedCount = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      long amount = Long.parseLong(st.nextToken());
      if (amount > 0) {
        sum += amount;
        totalDeposit += amount;
      } else {
        long temp = -amount;
        if (sum >= temp) {
          sum += amount;
        } else {
          failedCount++;
        }
      }
    }
    System.out.println(totalDeposit);
    System.out.println(failedCount);
  }

  private static void calculateDistance() {
    int n = sc.nextInt();
    int[] latitude = new int[n];
    int[] longitude = new int[n];
    for (int i = 0; i < n; i++) {
        longitude[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
        latitude[i] = sc.nextInt();
    }
    double distance = 0;
    double maxDistance = 0;
    int pointIndex = 0;
    int point2Index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            distance = distance(longitude[i], latitude[i], longitude[j], latitude[j]);
            if (distance > maxDistance) {
                maxDistance = distance;
                pointIndex = i;
                point2Index = j;
            }
        }
    }
    System.out.println(longitude[pointIndex] + " " + latitude[pointIndex]);
    System.out.println(longitude[point2Index] + " " + latitude[point2Index]);
  }

  private static double distance(int longitude1, int latitude1, int longitude2, int latitude2) {
    return Math.sqrt(mathSquare(longitude2 - longitude1) + mathSquare(latitude2 - latitude1));
  }

  private static double mathSquare(double x) {
    return x * x;
  }
}