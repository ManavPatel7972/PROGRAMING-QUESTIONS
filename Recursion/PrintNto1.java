package Recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        int n = 5;

        printNTo1(n);
    }

    public static void printNTo1(int n) {
        if (n < 1)
            return;

        System.out.println(n);
        // n = n - 1;
        // printNTo1(n);

        printNTo1(--n);
    }

    public static void demo(int n) {
        if (n == 0)
            return;

        System.out.println(n);

        demo(--n);
    }
}
