import java.io.*;
import java.util.*;

public class EISTULI {
  
  static class Student implements Comparable<Student> {
    private static final double EPSILON = 1e-9;
    private static final int CREDITS_PER_COURSE = 4;
    private static final int PASSING_SCORE = 50;
    
    String id;
    String name;
    double gpa;
    int credits;
    int inputOrder;
    
    static Student fromCourseScores(String id, String name, int[] scores, int inputOrder) {
      int sum = 0;
      int validCount = 0;
      
      for (int score : scores) {
        if (score >= PASSING_SCORE) {
          sum += score;
          validCount++;
        }
      }
      
      if (validCount == 0) {
        return null;
      }
      
      double gpa = (double) sum / validCount;
      int credits = validCount * CREDITS_PER_COURSE;
      return new Student(id, name, gpa, credits, inputOrder);
    }
    
    private Student(String id, String name, double gpa, int credits, int inputOrder) {
      this.id = id;
      this.name = name;
      this.gpa = gpa;
      this.credits = credits;
      this.inputOrder = inputOrder;
    }
    
    boolean hasSameGPA(Student other) {
      return Math.abs(this.gpa - other.gpa) < EPSILON;
    }
    
    boolean hasStrictlyBetterGPA(Student other) {
      return this.gpa > other.gpa + EPSILON;
    }
    
    @Override
    public int compareTo(Student other) {
      if (Math.abs(this.gpa - other.gpa) < EPSILON) {
        return Integer.compare(this.inputOrder, other.inputOrder);
      }
      return Double.compare(other.gpa, this.gpa);
    }
    
    String toOutputString() {
      return id + " " + name + " " + Math.round(gpa) + " " + credits;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int n = Integer.parseInt(firstLine[0]);
    int k = Integer.parseInt(firstLine[1]);
    
    List<Student> students = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] tokens = br.readLine().split(" ");
      String id = tokens[0];
      String name = tokens[1];
      int numCourses = Integer.parseInt(tokens[2]);

      int[] scores = new int[numCourses];
      for (int j = 0; j < numCourses; j++) {
        scores[j] = Integer.parseInt(tokens[3 + j]);
      }

      Student student = Student.fromCourseScores(id, name, scores, i);
      if (student != null) {
        students.add(student);
      }
    }

    Collections.sort(students);

    StringBuilder sb = new StringBuilder();

    if (k > 0 && !students.isEmpty()) {
      int actualK = Math.min(k, students.size());
      Student kthStudent = students.get(actualK - 1);

      // Count students with k-th GPA
      int countAtKth = 0;
      for (Student s : students) {
        if (s.hasSameGPA(kthStudent)) {
          countAtKth++;
        }
      }

      // Find position of first student with k-th GPA
      int positionOfFirstKthGPA = -1;
      for (int i = 0; i < students.size(); i++) {
        if (students.get(i).hasSameGPA(kthStudent)) {
          positionOfFirstKthGPA = i;
          break;
        }
      }

      // If all students with k-th GPA can fit within top k, output them all
      // Otherwise, output only students with strictly better GPA
      if (positionOfFirstKthGPA + countAtKth <= k) {
        // All tied students fit, output all with GPA >= kthGPA
        for (Student s : students) {
          if (s.hasSameGPA(kthStudent) || s.hasStrictlyBetterGPA(kthStudent)) {
            sb.append(s.toOutputString()).append("\n");
          }
        }
      } else {
        // Not all tied students fit, output only students with strictly better GPA
        for (Student s : students) {
          if (s.hasStrictlyBetterGPA(kthStudent)) {
            sb.append(s.toOutputString()).append("\n");
          }
        }
      }
    }

    System.out.print(sb.toString());
    br.close();
  }
}
