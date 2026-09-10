public class AddDigit {
    public static void main(String[] args) {

    }

    public int addDigit(int num) {

        while (num >= 10) {

            String str = String.valueOf(num);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }

            num = sum;
        }

        return num;
    }
}