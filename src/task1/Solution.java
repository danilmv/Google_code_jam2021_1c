package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            list.clear();
            for (int j = 0; j < n; j++)
                list.add(scanner.nextInt());
            Collections.sort(list);

            int prevVal = 0;
            int length = 0, start = 0, end = 0, middle1 = 0, middle2 = 0;

            for (Integer value : list) {
                length = value - prevVal - 1;
                if (prevVal == 0)
                    start = length;
                else {
                    if (length > middle1) {
                        if (middle1 > middle2)
                            middle2 = middle1;
                        middle1 = length;
                    } else if (length > middle2)
                        middle2 = length;
                }

                prevVal = value;
            }
            end = k - prevVal;


            int max = middle1;

            middle1 = (int) (middle1 / 2.0 + 0.5);
            middle2 = (int) (middle2 / 2.0 + 0.5);

            list.clear();
            list.add(start);
            list.add(end);
            list.add(middle1);
            list.add(middle2);
            Collections.sort(list);

            if (max < list.get(2) + list.get(3))
                max = list.get(2) + list.get(3);

            System.out.printf("Case #%d: %f\n", i + 1, max / (double) k);
        }
    }
}
