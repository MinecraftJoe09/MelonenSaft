package eu.melonensaft.minecraftjoe09.melonensaft.utils;

public class Digit {

    int digit;

    public Digit(int digit) {
        this.digit = digit;
    }

    public int addBack(int i) {
        int digit = this.digit;
        boolean bool = true;
        if (i >= 0) {
            for (int i1 = 10; i1 <= 1000000000 && bool; i1 *= 10) {
                if (i < i1) {
                    digit *= i1;
                    digit += i;
                    bool = false;
                }
            }
        }
        return digit;
    }
}
