import java.math.BigInteger;

public class PlusOne {
    public static void main(String[] args) {
        
    }

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();

        for (int d : digits) {
            sb.append(d);
        }

        BigInteger b = new BigInteger(sb.toString());

        b = b.add(BigInteger.ONE);

        String res = b.toString();

        int[] ans = new int[res.length()];

        for (int i = 0; i < res.length(); i++) {
            ans[i] = res.charAt(i) - '0';
        }

        return ans;
    }
}
