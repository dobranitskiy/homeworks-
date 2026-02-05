package com.homework;

public class Hangman {
    static void main(String[] args) {
        InputOutput inpOut = new InputOutput();
        WordInfo word = new WordInfo();
        Graphics graphics = new Graphics();

        Integer category = inpOut.chooseCategory();
        Integer difficulty = inpOut.chooseDifficulty();

        Session session = word.createSession(category, difficulty);

        Integer startIndex;
        switch (difficulty) {
            case 2:
                startIndex = 2;
                break;
            case 1:
                startIndex = 1;
                break;
            default:
                startIndex = 0;
        }

        while (!session.isGameOver()) {
            graphics.draw(session.getWrongAttempts(), startIndex);
            inpOut.printWord(session.getWord());
            inpOut.printAttempts(session);
            String input = inpOut.readLetter();

            if (!session.processInput(input)) {
                inpOut.printMessage("Введите одну букву.");
                inpOut.waitForEnter();
            }
        }

        graphics.draw(session.getWrongAttempts(), startIndex);
        if (session.isWon()) {
            System.out.println("Победа!");
        } else {
            System.out.println("Поражение. Слово: " + session.getSecretWord());
        }
    }
}
