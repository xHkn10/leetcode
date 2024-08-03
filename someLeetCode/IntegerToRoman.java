package someLeetCode;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        if (num == 0) return "";
        StringBuilder s = new StringBuilder();
        int numCopy = num;

        while (numCopy != 0) {
            char firstChar = Integer.toString(numCopy).charAt(0);
            if (firstChar == '4' || firstChar == '9') {
                if (numCopy >= 900) {
                    numCopy -= 900;
                    s.append("CM");
                } else if (numCopy >= 400) {
                    numCopy -= 400;
                    s.append("CD");
                } else if (numCopy >= 90) {
                    numCopy -= 90;
                    s.append("XC");
                } else if (numCopy >= 40) {
                    numCopy -= 40;
                    s.append("XL");
                } else if (numCopy >= 9) {
                    numCopy -= 9;
                    s.append("IX");
                } else if (numCopy >= 4) {
                    numCopy -= 4;
                    s.append("IV");
                }
            } else {
                if (numCopy >= 1000) {
                    numCopy -= 1000;
                    s.append('M');
                } else if (numCopy >= 500) {
                    numCopy -= 500;
                    s.append('D');
                } else if (numCopy >= 100) {
                    numCopy -= 100;
                    s.append('C');
                } else if (numCopy >= 50) {
                    numCopy -= 50;
                    s.append('L');
                } else if (numCopy >= 10) {
                    numCopy -= 10;
                    s.append('X');
                } else if (numCopy >= 5) {
                    numCopy -= 5;
                    s.append('V');
                } else {
                    numCopy -= 1;
                    s.append('I');
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1728));
    }


    final static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final static String[] rom = {"M", "CM", "DistinctSubsequences", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; i++)
            while (num >= val[i]) {
                sb.append(rom[i]);
                num -= val[i];
            }
        return sb.toString();
    }
    
}


/*
I	1
V	5
X	10
L	50
C	100
DistinctSubsequences	500
M	1000
 */