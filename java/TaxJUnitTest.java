import org.junit.Test;
import static org.junit.Assert.*;

public class TaxJUnitTest {
    
    @Test
    public void testCalculateTax_ZeroSalary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(0, limits, rates);
        assertEquals(0.0, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_FirstBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(3, limits, rates);
        assertEquals(0.15, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_SecondBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(7, limits, rates);
        assertEquals(0.45, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_ThirdBracket() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(15, limits, rates);
        assertEquals(1.50, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_ExactBracketBoundary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(5, limits, rates);
        assertEquals(0.25, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_VietnameseSystem() {
        double[] limits = {5, 10, 18, 32, 52, 80, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};
        
        assertEquals(0.15, Tax.calculateTax(3, limits, rates), 0.001);
        assertEquals(0.45, Tax.calculateTax(7, limits, rates), 0.001);
        assertEquals(1.50, Tax.calculateTax(15, limits, rates), 0.001);
        assertEquals(3.35, Tax.calculateTax(25, limits, rates), 0.001);
        assertEquals(6.75, Tax.calculateTax(40, limits, rates), 0.001);
        assertEquals(12.15, Tax.calculateTax(60, limits, rates), 0.001);
        assertEquals(21.65, Tax.calculateTax(90, limits, rates), 0.001);
    }
    
    @Test
    public void testCalculateTax_NegativeSalary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(-1000, limits, rates);
        assertEquals(0.0, result, 0.001);
    }
    
    @Test
    public void testCalculateTax_LargeSalary() {
        double[] limits = {5, 10, Double.MAX_VALUE};
        double[] rates = {0.05, 0.10, 0.15};
        
        double result = Tax.calculateTax(1000, limits, rates);
        assertEquals(149.25, result, 0.001); // 5*0.05 + 5*0.10 + 990*0.15 = 0.25 + 0.50 + 148.50 = 149.25
    }
}
