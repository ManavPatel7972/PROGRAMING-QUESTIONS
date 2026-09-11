package Array;

public class Unique_3DigitNumbers {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        System.out.println("Output = " + totalNumbers(arr));
    }

    public static int totalNumbers(int[] arr) {
        int[] fre = new int[10];

        for (int i : fre) {
            fre[i]++;
        }

        int cnt = 0;

        for (int i = 100; i < 999; i += 2) {

            int one = i % 10;
            int ten = (i / 10) % 10;
            int hundred = i / 100;

            // check if required fre available
            if (one == ten && ten == hundred) {

                // need 3 freq
                if (fre[one] >= 3) {
                    cnt++;
                }

            } else if (one == ten) {
                // need 2 freq
                if (fre[one] >= 2 && fre[hundred] >= 1) {
                    cnt++;
                }
            } else if (one == hundred) {
                if (fre[one] >= 2 && fre[ten] >= 1) {
                    cnt++;
                }
            } else if (ten == hundred) {
                if (fre[ten] >= 2 && fre[one] >= 1) {
                    cnt++;
                }
            } else {

                if (fre[one] >= 1 && fre[ten] >= 1 && fre[hundred] >= 1) {
                    cnt++;
                }
            }

        }

        return cnt;

    }

}
