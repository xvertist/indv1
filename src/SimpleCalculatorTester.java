import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleCalculatorTester {

    @Test
    public void addition() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("11.0", tester.calculate("5.5 + 5.5"), "Should equal 11.0");
    }

    @Test
    public void subtraction() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("5.283", tester.calculate("7.634 - 2.351"), "Should equal 5.283");
    }

    @Test
    public void multiply() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("56.7", tester.calculate("3.5 * 16.2"), "Should equal 56.7");
    }

    @Test
    public void divide() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("0.44737", tester.calculate("17 / 38"), "Should equal 0.44737");
    }


    @Test
    public void LongEquation() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("200.60392", tester.calculate("( ( 17.543 + 16.423 ) * 7.12 ) - 41.234"), "Should equal 200.60392");
    }

    @Test
    public void InvalidExpression() {
        SimpleCalculator tester = new SimpleCalculator(); // MyClass is tested

        // assert statement for addition
        assertEquals("Invalid Expression
        ", tester.calculate("This is not math"), "Should equal 'Invalid Expression'");
    }

}