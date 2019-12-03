import java.util.*;

public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String hexNumberStr = sc.nextLine();

            int result = convert(hexNumberStr.substring(2));

//            int base = 0;
//            int result = 0;
//
//            for (int i = hexNumberStr.length() - 1; i >= 2; i--) {
//                String ch = hexNumberStr.substring(i, i + 1);
//
//                int number;
//
//                if (ch.equalsIgnoreCase("a")) {
//                    number = 10;
//                } else if (ch.equalsIgnoreCase("b")) {
//                    number = 11;
//                } else if (ch.equalsIgnoreCase("c")) {
//                    number = 12;
//                } else if (ch.equalsIgnoreCase("d")) {
//                    number = 13;
//                } else if (ch.equalsIgnoreCase("e")) {
//                    number = 14;
//                } else if (ch.equalsIgnoreCase("f")) {
//                    number = 15;
//                } else {
//                    number = Integer.parseInt(ch);
//                }
//
//                result += number * Math.pow(16, base);
//
//                base++;
//            }

            System.out.println(result);
        }
    }

    private static int convert(String hex) {
        int oct = 0;

        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(hex.length() - 1 - i);
            int num = 0;

            if (ch >= '0' && ch <= '9') {
                num = ch - '0';
            } else if (ch >= 'A' && ch <= 'Z') {
                num = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                num = ch - 'a' + 10;
            }

            oct += num * Math.pow(16, i);
        }

        return oct;
    }
}
