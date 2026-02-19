package DynamicArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите стратегию расширения:");
        System.out.println("1 - DoublingStrategy");
        System.out.println("2 - FixedIncrementStrategy");
        System.out.println("3 - GoldenRatioStrategy");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        CapacityStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new DoublingStrategy();
                break;
            case 2:
                System.out.print("Введите шаг увеличения: ");
                int increment = scanner.nextInt();
                strategy = new FixedIncrementStrategy(increment);
                break;
            case 3:
                strategy = new GoldenRatioStrategy();
                break;
            default:
                System.out.println("Некорректный ввод. Используется 1 стратегия");
                strategy = new DoublingStrategy();
        }

        DynamicIntArray array = new DynamicIntArray(strategy);
        System.out.println("\nПуст ли массив?: " + array.isEmpty());
        array.add(10);
        array.add(20);
        array.add(20);
        array.add(40);
        array.add(40);
        System.out.println("\nПуст ли массив?: " + array.isEmpty());
        System.out.println("\nРазмер: " + array.size());
        System.out.println("\nМассив: " + array);
        array.remove(0);
        System.out.println("\nРазмер: " + array.size());
        System.out.println("\nМассив: " + array);
        scanner.close();
    }
}
