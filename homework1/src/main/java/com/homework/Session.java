package com.homework;

public class Session {
    private final String word;
    private final Integer maxAttempts;
    private Integer wrongAttempts = 0;

    private final Character[] guessedLetters = new Character[26];
    private Integer cnt = 0;

    public Session(String secretWord, Integer maxAttempts) {
        this.word = secretWord.toLowerCase();
        this.maxAttempts = maxAttempts;
    }

    public boolean processInput(String input) {
        if (input == null || input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            return false;
        }

        Character letter = Character.toLowerCase(input.charAt(0));
        for (int i = 0; i < cnt; i++) {
            if (guessedLetters[i] == letter) {
                return true;
            }
        }
        guessedLetters[cnt++] = letter;
        if (!word.contains(String.valueOf(letter))) {
            wrongAttempts++;
        }
        return true;
    }

    public boolean isWon() {
        for (char c : word.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < cnt; i++) {
                if (guessedLetters[i] == c) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return isWon() || wrongAttempts >= maxAttempts;
    }

    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < cnt; i++) {
                if (guessedLetters[i] == c) {
                    found = true;
                    break;
                }
            }
            sb.append(found ? c : "_").append(" ");
        }
        return sb.toString();
    }

    public Integer getWrongAttempts() {
        return wrongAttempts;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public String getSecretWord() {
        return word;
    }
}
