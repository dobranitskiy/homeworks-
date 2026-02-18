package com.homework;

public class Graphics {
    private final String[] hangmanGraphics = {
            "|------\n|    | \n|      \n|      \n|      \n|      \n|      \n|      \n#######",
            "|------\n|    | \n|    | \n|      \n|      \n|      \n|      \n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|      \n|      \n|      \n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|    | \n|      \n|      \n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|    | \n|    0 \n|      \n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|    | \n|    0 \n|    | \n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|    | \n|    0 \n|   -|-\n|      \n#######",
            "|------\n|    | \n|    | \n|    | \n|    | \n|    0 \n|   -|-\n|   / \\\n#######",
    };

    public void draw(Integer wrongAttempts, Integer startIndex) {
        System.out.println(hangmanGraphics[startIndex + wrongAttempts]);
    }
}