package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        int po = 0;
        int pc = post.length;
        int to = word.length - pc;
        while (po < pc) {
            if (word[to++] != post[po++]) {
                return false;
            }
        }
        return true;
    }
}