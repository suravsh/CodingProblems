/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.hackerearth.amazon;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 10/07/16
 * Version : v1
 */
public class VasyaAndParty {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;

    private static int MOD = 1000000007;


    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {

        int N = nextInt();
        int M = nextInt();
        int[] A = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            A[n] = nextInt();
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        adjacencyList.add(new ArrayList<Integer>());
        for (int n = 0; n < N; n++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for (int m = 0; m < M; m++) {
            int u = nextInt();
            int v = nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visted = new boolean[N + 1];
        long result = 1;
        for (int n = 1; n <= N; n++) {
            if (!visted[n]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(n);
                int max = -1;
                int occurences = 0;
                while (!queue.isEmpty()) {
                    int top = queue.poll();
                    if (max < A[top]) {
                        occurences = 1;
                        max = A[top];
                    } else if (max == A[top]) {
                        occurences++;
                    }
                    visted[top] = true;
                    List<Integer> list = adjacencyList.get(top);
                    for (Integer i : list) {
                        if (!visted[i]) {
                            queue.add(i);
                            visted[i] = true;
                        }
                    }
                }
                result *= occurences;
                result %= MOD;
            }
        }
        pw.println(result);

    }


}
