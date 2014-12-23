package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndPairs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Map<Integer, Long> map = new HashMap<>();

            for (int n = 0; n < N; n++) {
                int i = scanner.nextInt();
                long count = 0;
                if (map.containsKey(i)) {
                    count = map.get(i);
                }
                count++;
                map.put(i, count);
            }

            long count = 0;
            for (int key : map.keySet()) {
                long value = map.get(key);
                if (value > 1) {
                    count += value * (value - 1);
                }
            }
            pw.println(count);
        }

        scanner.close();
        pw.close();

    }
}
