public class Converter {
    int convertToKm(int steps) {
        return 75 * steps / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        return 50 * steps / 1000;
    }
}
