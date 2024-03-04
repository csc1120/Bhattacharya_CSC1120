package Week7a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @Test
    public void testBoundary() {
        String filerType = "s";
        double income = 0;
        double expectedTax = 0;

        double actualTax = TaxCalculator.singleTaxCalculator(income);

        assertEquals(expectedTax, actualTax, 0.01);
    }
    @Test
    public void testSingleFilerValidInput() {
        String filerType = "s";
        double income = 75000;
        double expectedTax = 12117.0;

        double actualTax = TaxCalculator.singleTaxCalculator(income);

        assertEquals(expectedTax, actualTax, 0.01);
    }

    @Test
    public void testSingleFilerExceedsFirstBracket() {
        String filerType = "s";
        double income = 100000;
        double expectedTax = 5674.5;

        double actualTax = TaxCalculator.singleTaxCalculator(income);

        assertEquals(expectedTax, actualTax, 0.01);
    }

    @Test
    public void testJointFilerValidInput() {
        String filerType = "j";
        double income = 8000;
        double expectedTax = 0;

        double actualTax = TaxCalculator.jointTaxCalculator(income);

        assertEquals(expectedTax, actualTax, 0.01);
    }

    @Test
    public void testJointFilerExceedsFirstBracket() {
        String filerType = "j";
        double income = 150000;
        double expectedTax = 9072.5;

        double actualTax = TaxCalculator.jointTaxCalculator(income);

        assertEquals(expectedTax, actualTax);
    }

}
