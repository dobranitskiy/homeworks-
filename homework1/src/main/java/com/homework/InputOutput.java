package com.homework;

import java.util.Scanner;

public class InputOutput {
    private final Scanner scanner = new Scanner(System.in);

    public Integer chooseCategory() {
        System.out.println("Выберите категорию (Enter - случайная):");
        System.out.println("1 - Животные");
        System.out.println("2 - Еда");
        System.out.println("3 - Футболисты");
        System.out.print("Ваш выбор: ");

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return (int)(Math.random() * 3);
        }

        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            return Integer.parseInt(input) - 1;
        }

        System.out.println("Некорректный ввод. Будет выбрана случайная категория.");
        return (int)(Math.random() * 3);
    }

    public Integer chooseDifficulty() {
        System.out.println("Выберите сложность (Enter - случайная):");
        System.out.println("1 - Лёгкая (7 ошибок)");
        System.out.println("2 - Средняя (6 ошибок)");
        System.out.println("3 - Сложная (5 ошибок)");
        System.out.print("Ваш выбор: ");

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return (int)(Math.random() * 3);
        }

        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            return Integer.parseInt(input) - 1;
        }

        System.out.println("Некорректный ввод. Будет выбрана случайная сложность.");
        return (int)(Math.random() * 3);
    }

    public String readLetter() {
        System.out.print("\nВведите букву: ");
        return scanner.nextLine().trim();
    }

    public void printWord(String word) {
        System.out.println("\nСлово: " + word);
    }

    public void printAttempts(Session session) {
        System.out.println("Ошибки: " + session.getWrongAttempts() + "/" + session.getMaxAttempts());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void waitForEnter() {
        System.out.print("Нажмите Enter...");
        scanner.nextLine();
    }
}