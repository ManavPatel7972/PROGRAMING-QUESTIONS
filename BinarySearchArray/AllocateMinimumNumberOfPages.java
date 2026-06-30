// Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));

        int n = 5;
        // no of student
        int m = 4;
        int ans = findPagesOptimal(arr, n, m);
        System.out.println("The answer is: " + ans);
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr);
        int high = sumVal(arr);

        for (int i = low; i <= high; i++) {
            if (countStudents(arr, i) == m) {
                return i;
            }
        }

        return low;
    }

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int stu = 1;
        int pagesSum = 0;

        for (int i = 0; i < n; i++) {
            if (pagesSum + arr.get(i) <= pages) {
                pagesSum += arr.get(i);

            } else {
                stu++;
                pagesSum = arr.get(i);
            }
        }

        return stu;
    }

    public static int sumVal(ArrayList<Integer> arr) {
        int sum = 0;

        for (Integer integer : arr) {
            sum += (int) integer;
        }

        return sum;

    }

    public static int findPagesOptimal(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr);
        int high = sumVal(arr);
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int stu = countStudents(arr, mid);

            if (stu > m) {
                low = mid + 1;
            }

            else {
                ans = mid;
                high = mid - 1;
            }

        }

        return ans;
        // return low;
    }
}