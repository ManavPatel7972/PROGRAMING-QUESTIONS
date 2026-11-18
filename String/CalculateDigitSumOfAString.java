public class CalculateDIgitSumOfAString {
    public static void main(String[] args) {

    }

    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {

                int sum = 0;

                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }

                result.append(sum);
            }

            s = result.toString();
        }

        return s;

    }

    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder result = new StringBuilder();

            int i = 0;

            while (i < s.length()) {

                int sum = 0;
                int count = 0;

                while (i < s.length() && count < k) {
                    sum += s.charAt(i) - '0';
                    i++;
                    count++;
                }

                result.append(sum);
            }

            s = result.toString();
        }

        return s;
    }

}