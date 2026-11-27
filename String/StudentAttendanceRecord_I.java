package String;

public class StudentAttendanceRecord_I {
    public static void main(String[] args) {

    }

    public boolean checkRecord(String s) {

        int absent = 0, late = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'A')
                absent++;

            if (ch == 'L')
                late++;
            else
                late = 0;

            if (absent >= 2 || late >= 3)
                return false;
        }

        return true;
    }

    public boolean checkRecordAnotherWay(String s) {

        if (s.indexOf('A') != s.lastIndexOf('A'))
            return false;

        if (s.contains("LLL"))
            return false;

        return true;
    }
}
