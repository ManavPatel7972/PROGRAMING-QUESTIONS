package String;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 4;
        String binary = decimalToBinary(decimal);
        System.out.println("Binary = " + binary);
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0)
            return "0";

        StringBuilder str = new StringBuilder();

        while (decimal > 0) {
            int rem = decimal % 2;
            str.insert(0, rem);
            decimal = decimal / 2;
        }

        return str.toString();
    }
}