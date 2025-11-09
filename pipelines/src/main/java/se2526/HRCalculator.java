package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);
        double percent = (bpm / (double) maxHR) * 100;

        if (percent < 50) {
            return "Below zone";
        } else if (percent < 60) {
            return "Very Light";
        } else if (percent < 70) {
            return "Light";
        } else if (percent < 80) {
            return "Moderate";
        } else if (percent < 90) {
            return "Hard";
        } else if (percent <= 100) {
            return "Maximum";
        } else {
            return "Above maximum";
        }
    }
}