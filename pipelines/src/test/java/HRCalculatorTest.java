import org.junit.jupiter.api.Test;
import se2526.HRCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testWorkoutZone_BelowZone() {
        assertEquals("Below zone", HRCalculator.getWorkoutZone(40, 80));
        // 80bpm<50% of 180 = app.44%
    }

    @Test
    public void testWorkoutZone_VeryLight() {
        assertEquals("Very Light", HRCalculator.getWorkoutZone(40, 100));
        // app.56%
    }

    @Test
    public void testWorkoutZone_Light() {
        assertEquals("Light", HRCalculator.getWorkoutZone(40, 115));
        // app.64%
    }

    @Test
    public void testWorkoutZone_Moderate() {
        assertEquals("Moderate", HRCalculator.getWorkoutZone(40, 135));
        // app.75%
    }

    @Test
    public void testWorkoutZone_Hard() {
        assertEquals("Hard", HRCalculator.getWorkoutZone(40, 155));
        // app.86%
    }

    @Test
    public void testWorkoutZone_Maximum() {
        assertEquals("Maximum", HRCalculator.getWorkoutZone(40, 175));
        // app.97%
    }

    @Test
    public void testWorkoutZone_AboveMaximum() {
        assertEquals("Above maximum", HRCalculator.getWorkoutZone(40, 200));
        // >100%
    }

}