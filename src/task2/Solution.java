package task2;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String line = null;
            while (line == null || line.isEmpty()) {
                line = scanner.nextLine();
            }
            BigInteger y = new BigInteger(line);
            int length = y.toString().length();

            BigInteger min = null;
            int up = (int)Math.pow(10, (int)((length) / 2));

            for (int j = 0; j <= up; j++) {
                BigInteger next = getNum(j, length);
                if (next.compareTo(y) <= 0)
                    next = getNum(j, length + 1);
                if (y.compareTo(next) < 0)
                    if (min == null || min.compareTo(next) > 0)
                        min = next;
            }


            System.out.printf("Case #%d: %s\n", i + 1, (min != null ? min.toString() : ""));
        }
    }

    public static BigInteger getNum(int start, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= start + length; i++) {
            sb.append(i);
            if (sb.toString().length() >= length && i != start) break;
        }

        return new BigInteger(sb.toString());
    }
}
