package Recursion;

public class SumOf1ToN {
    public static void main(String[] args) {
        int n = 5;

       System.out.println("Sum = " + functionalSum(n));
    }

    public static void sumOf1ToN(int i, int sum) {
        if (i < 1) {
            System.out.println("Sum = " + sum);
            return;
        }

        sumOf1ToN(i - 1, sum + i);
    }

    public static int functionalSum(int n) {
        if (n == 0)
            return 0;

        return n + functionalSum(n - 1);
    }
}
