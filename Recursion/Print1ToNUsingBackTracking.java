package Recursion;

public class Print1ToNUsingBackTracking {
    public static void main(String[] args) {
        int n = 5;

        print1ToNBackTracking(n);
    }

    public static void print1ToNBackTracking(int n) {
        if (n==0)
            return;

        print1ToNBackTracking(n-1);

        System.out.println(n);
    }
}
