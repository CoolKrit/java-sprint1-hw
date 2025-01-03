public class Converter {
    static final int oneStepToCm = 75;
    static final int oneKmToCm = 100000;

    static final int oneStepCal = 50;
    static final int oneKcalToCal = 1000;

    int convertToKm(int steps) {
        return oneStepToCm * steps / oneKmToCm;
    }

    int convertStepsToKilocalories(int steps) {
        return oneStepCal * steps / oneKcalToCal;
    }
}
