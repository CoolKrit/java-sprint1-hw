public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }

        return sumSteps;
    }

    int maxStepsFromMonth() {
        int maxSteps = 0;
        for (int day : days) {
            if (day > maxSteps) {
                maxSteps = day;
            }
        }

        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int[] bestS = new int[30];
        int i = 0;
        int maxSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                bestS[i] += 1;
            } else {
                i++;
            }
        }

        for (int best : bestS) {
            if (best > maxSeries) {
                maxSeries = best;
            }
        }

        return maxSeries;
    }
}
