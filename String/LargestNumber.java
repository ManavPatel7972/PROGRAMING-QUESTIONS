public class LargestNumber {
    public static void main(String[] args) {

        int[] num = new int[] { 10, 2 };
        System.out.println("Res = " + largest(num));
    }

    public static String largest(int[] num) {

        String[] arr = new String[num.length];

        for (int i = 0; i < num.length; i++) {
            arr[i] = String.valueOf(num[i]);
        }

        for (int i = 0; i < arr.length(); i++) {
            for (int j = i + 1; j < arr.length(); j++) {

                String first = arr[i] + arr[j];
                String second = arr[j] + arr[i];

                if (isBigger(second, first)) {

                    // swap
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
        }

        // handle "000" -> "0";
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static boolean isBigger(String s, String f) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) > f.charAt(i)) {
                return true;
            }

            if (s.charAt(i) < f.charAt(i)) {
                return true;
            }
        }

        return false;
    }
}
