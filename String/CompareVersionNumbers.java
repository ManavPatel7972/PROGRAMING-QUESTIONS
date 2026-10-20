package String;

public class CompareVersionNumbers {
    public static void main(String[] args) {

    }

    public static int compareVersion(String version1, String version2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                s1.append("-");
            } else {
                s1.append(version1.charAt(i));
            }
        }

        for (int j = 0; j < version2.length(); j++) {
            if (version2.charAt(j) == '.') {
                s2.append("-");
            } else {
                s2.append(version2.charAt(j));
            }
        }

        String[] v1 = s1.toString().split("-");
        String[] v2 = s2.toString().split("-");

        int len = Math.max(v1.length, v2.length);

        for (int i = 0; i < len; i++) {
            int n1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int n2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            if (n1 < n2) {
                return -1;
            }
            if (n1 > n2) {
                return 1;
            }
        }
        return 0;
    }
}
