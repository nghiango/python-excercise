public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running Tax Tests...");
        
        try {
            TaxTest test = new TaxTest();
            
            test.testCalculateTax_ZeroSalary();
            System.out.println("✓ testCalculateTax_ZeroSalary passed");
            
            test.testCalculateTax_FirstBracket();
            System.out.println("✓ testCalculateTax_FirstBracket passed");
            
            test.testCalculateTax_SecondBracket();
            System.out.println("✓ testCalculateTax_SecondBracket passed");
            
            test.testCalculateTax_ThirdBracket();
            System.out.println("✓ testCalculateTax_ThirdBracket passed");
            
            test.testCalculateTax_ExactBracketBoundary();
            System.out.println("✓ testCalculateTax_ExactBracketBoundary passed");
            
            test.testCalculateTax_VietnameseSystem();
            System.out.println("✓ testCalculateTax_VietnameseSystem passed");
            
            System.out.println("\n🎉 All tests passed!");
            
        } catch (AssertionError e) {
            System.err.println("❌ Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error running tests: " + e.getMessage());
        }
    }
}
