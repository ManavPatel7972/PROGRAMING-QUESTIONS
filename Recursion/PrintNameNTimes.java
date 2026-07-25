package Recursion;

public class PrintNameNTimes {
    public static void main(String[] args) {
        int n = 10;
        print(1, n);
    }

    public static void print(int i, int n) {
        if (i > n)
            return;

        System.out.println("Hello Manuu.." + i);

        print(i + 1, n);
    }

}
