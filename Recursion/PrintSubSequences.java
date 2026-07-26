package Recursion;

import java.util.ArrayList;

public class PrintSubSequences {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        int n = arr.length;
        ArrayList<Integer> sub = new ArrayList<>();

        printSubSequences(0, sub, arr, n);
    }

    public static void printSubSequences(int ind, ArrayList<Integer> sub, int[] arr, int n) {
        if (ind == n) {
            for (int i : sub) {
                System.out.print(i + " ");
            }

            if (sub.size() == 0) {
                System.out.print("{}");
            }

            System.out.println();
            return;
        }

        sub.add(arr[ind]);
        printSubSequences(ind + 1, sub, arr, n);
        sub.removeLast();
        printSubSequences(ind + 1, sub, arr, n);

    }
}
