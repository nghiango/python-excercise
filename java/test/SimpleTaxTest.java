public class SimpleTaxTest {
    
    public static void main(String[] args) {
        System.out.println("Running Tax Tests...\n");
        
        // Test 1: Zero salary
        testZeroSalary();
        
        // Test 2: First bracket
        testFirstBracket();
        
        // Test 3: Second bracket
        testSecondBracket();
        
        // Test 4: Third bracket
        testThirdBracket();
        
        // Test 5: Exact boundary
        testExactBoundary();
        
        // Test 6: Vietnamese system
        testVietnameseSystem();
        
        System.out.println("\n🎉 All tests completed!");
    }
    
    private static void testZeroSalary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(0, limits, rates);
        boolean passed = Math.abs(result - 0.0) < 0.001;
        
        System.out.println("Test 1 - Zero salary: " + 
                          (passed ? "✓ PASSED" : "❌ FAILED") + 
                          " (Expected: 0.0, Got: " + result + ")");
    }
    
    private static void testFirstBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(3, limits, rates);
        boolean passed = Math.abs(result - 0.15) < 0.001;
        
        System.out.println("Test 2 - First bracket: " + 
                          (passed ? "✓ PASSED" : "❌ FAILED") + 
                          " (Expected: 0.15, Got: " + result + ")");
    }
    
    private static void testSecondBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(7, limits, rates);
        boolean passed = Math.abs(result - 0.45) < 0.001;
        
        System.out.println("Test 3 - Second bracket: " + 
                          (passed ? "✓ PASSED" : "❌ FAILED") + 
                          " (Expected: 0.45, Got: " + result + ")");
    }
    
    private static void testThirdBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(15, limits, rates);
        boolean passed = Math.abs(result - 1.50) < 0.001;
        
        System.out.println("Test 4 - Third bracket: " + 
                          (passed ? "✓ PASSED" : "❌ FAILED") + 
                          " (Expected: 1.50, Got: " + result + ")");
    }
    
    private static void testExactBoundary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(5, limits, rates);
        boolean passed = Math.abs(result - 0.25) < 0.001;
        
        System.out.println("Test 5 - Exact boundary: " + 
                          (passed ? "✓ PASSED" : "❌ FAILED") + 
                          " (Expected: 0.25, Got: " + result + ")");
    }
    
    private static void testVietnameseSystem() {
        double[] limits = {5, 10, 18, 32, 52, 80, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};
        
        boolean allPassed = true;
        
        // Test cases for Vietnamese system
        double[][] testCases = {
            {3, 0.15},
            {7, 0.45},
            {15, 1.50},
            {25, 3.35},
            {40, 6.75},
            {60, 12.15},
            {90, 21.65}
        };
        
        for (double[] testCase : testCases) {
            double result = Tax.calculateTax(testCase[0], limits, rates);
            boolean passed = Math.abs(result - testCase[1]) < 0.001;
            if (!passed) allPassed = false;
        }
        
        System.out.println("Test 6 - Vietnamese system: " + 
                          (allPassed ? "✓ PASSED" : "❌ FAILED"));
    }
}
