import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    Converter converter;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 5000;

    StepTracker(Scanner scan, Converter conv) {
        scanner = scan;
        converter = conv;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Неверно введён номер месяца.");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно):");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Неверно введён номер дня.");
            return;
        }

        System.out.println("Введите количество шагов:");
        int stepsCount = scanner.nextInt();
        if (stepsCount < 0) {
            System.out.println("Неверно введено количество шагов.");
            return;
        }

        monthToData[monthNumber - 1].days[dayNumber - 1] = stepsCount;
    }

    void changeStepGoal() {
        System.out.println("Введите новое значение целя шагов:");
        int userGoal = scanner.nextInt();

        if (userGoal > 0) {
            goalByStepsPerDay = userGoal;
        } else {
            System.out.println("Вы ввели неверное значение.");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int monthNumber = scanner.nextInt();

        System.out.println("Количество пройденных шагов по дням:");
        monthToData[monthNumber - 1].printDaysAndStepsFromMonth();

        int sumSteps = monthToData[monthNumber - 1].sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);

        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthToData[monthNumber - 1].maxStepsFromMonth());

        System.out.println("Среднее количество шагов: " + sumSteps / monthToData[monthNumber - 1].days.length);

        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));

        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));

        System.out.println("Лучшая серия: " + monthToData[monthNumber - 1].bestSeries(goalByStepsPerDay));
    }
}
