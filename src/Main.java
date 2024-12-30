import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker(scanner, converter);
        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            if (choice == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (choice == 2) {
                stepTracker.changeStepGoal();
            } else if (choice == 3) {
                stepTracker.printStatistic();
            } else if (choice == 4) {
                System.out.println("Выход из приложения...");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет! Введите ещё раз.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Изменить цель по количеству шагов в день.");
        System.out.println("3. Напечатать статистику за определённый месяц.");
        System.out.println("4. Выйти из приложения.");
    }
}