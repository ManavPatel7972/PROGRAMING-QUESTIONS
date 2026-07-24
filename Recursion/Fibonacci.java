package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Nth  = " + recFibonacci(n));
    }

    public static void printFibonacci(int n) {
        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {

            System.out.print(first + ", ");

            int sum = first + second;
            first = second;
            second = sum;
        }
    }

    public static int getNthFibonacci(int n) {
        int first = 0;
        int second = 1;
        int k = 0;

        for (int i = 0; i < n; i++) {

            if (k == n) {
                return first;
            }

            int sum = first + second;
            first = second;
            second = sum;
            k++;
        }

        return first;
    }

    public static int recFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

}
