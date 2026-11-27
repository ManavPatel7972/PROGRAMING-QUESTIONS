package Math;

// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Given two integers x and y, return the Hamming distance between them.

public class HammingDistance {
    public static void main(String[] args) {

    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor > 0) {

            if (xor % 2 == 1) {
                count++;
            }

            xor = xor / 2;
        }

        return count;

    }
}
