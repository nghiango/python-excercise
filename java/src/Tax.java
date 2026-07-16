import java.util.*;

public class Tax {
    // Using two parallel arrays instead of objects
    private static final double[] TAX_LIMITS = {5, 10, 18, 32, 52, 80, Double.MAX_VALUE};
    private static final double[] TAX_RATES = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};

    public static void main(String[] args) {
        double[] salaries = {3, 7, 15, 25, 40, 60, 90, 100};
        //            0  0  0  0  0  0  0
        int[]array = {0, 3, 0, 1, 1, 1, 2};
        // xuc sac       1  2  3  4  5  6

        for (double salary : salaries) {
            double tax = calculateTax(salary, TAX_LIMITS, TAX_RATES);
            double netSalary = salary - tax;
            System.out.printf("Salary: %.1fM, Tax: %.2fM (%.1f%%), Net: %.2fM%n", 
                salary, tax, (tax/salary)*100, netSalary);
        }
        
        System.out.println("\n--- Different brackets example ---");
        double[] newLimits = {10, 20, 50, Double.MAX_VALUE};
        double[] newRates = {0.05, 0.10, 0.15, 0.20};
        
        double testSalary = 30;
        double newTax = calculateTax(testSalary, newLimits, newRates);
        System.out.printf("With new brackets: %.1fM salary = %.2fM tax%n", testSalary, newTax);
    }
    
    public static double calculateTax(double grossSalary, double[] limits, double[] rates) {
        if (grossSalary <= 0) {
            return 0;
        }
        
        double tax = 0;
        double previousLimit = 0;
        
        for (int i = 0; i < limits.length; i++) {
            if (grossSalary <= previousLimit) {
                break;
            }
            
            double taxableAmount = Math.min(grossSalary, limits[i]) - previousLimit;
            tax += taxableAmount * rates[i];
            
            previousLimit = limits[i];
        }
        
        return tax;
    }
}
