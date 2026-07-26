package Recursion;

import java.util.ArrayList;

public class PrintSubSequencesOfSumEqualToK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int sum = 2;
        int n = arr.length;
        ArrayList<Integer> sub = new ArrayList<>();

        printSubSequencesWithSumK(0, sub, 0, sum, arr, n);
    }

    public static void printSubSequencesWithSumK(int ind, ArrayList<Integer> sub, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
                for (int i : sub) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

            return;
        }

        sub.add(arr[ind]);
        s += arr[ind];
        printSubSequencesWithSumK(ind + 1, sub, s, sum, arr, n);
        s -= arr[ind];
        sub.removeLast();
        printSubSequencesWithSumK(ind + 1, sub, s, sum, arr, n);

    }
}