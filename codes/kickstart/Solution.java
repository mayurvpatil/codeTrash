import static java.lang.System.exit;

import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 April 19 | [ Monday ]
 * Time: 06 : 51 : 19
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class Solution {

  public void solve() throws Exception {
    int a = in.getInt();
    int[] n = in.getIntArray(a);

    int pre[] = new int[a];

    for (int i = 1; i < a; i++) {
      pre[i] = Math.abs(n[i] - n[i - 1]);
    }

    int tt;
    int result = 0;
    for (int i = 1; i < a - 1; i++) {
      if (n[i - 1] != n[i] && n[i - 1] == n[i + 1]) {
        tt = 1;

        int itr = i - 1;
        while (itr > 0 && pre[itr--] == pre[i - 1]) tt++;

        itr = i + 1;
        while (itr < a && pre[itr++] == pre[i - 1]) tt++;

        if (tt > result) result = tt;
      }
    }

    System.out.println(result);
  } // End

  public Solution() throws Exception {
    boolean isMultipleTestCases = true;
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);

    if (isMultipleTestCases) {
      int t = in.getInt();
      for (int i = 1; i <= t; ++i) {
        System.out.print("Case #" + i + ": ");
        solve();
      }
    } else {
      solve();
    }
    out.close();
  }

  public static void main(String[] args) {
    try {
      new Solution();
    } catch (Throwable e) {
      e.printStackTrace();
      exit(1);
    }
  }

  private InputReader in = null;
  private PrintWriter out = null;

  // FastIO reader
  static class InputReader {

    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String getLine() throws Exception {
      return reader.readLine();
    }

    public String getString() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int getInt() {
      return Integer.parseInt(getString());
    }

    public long getLong() {
      return Long.parseLong(getString());
    }

    public int[] getIntArray(int n) {
      int[] temp = new int[n];
      for (int i = 0; i < n; i++) temp[i] = getInt();
      return temp;
    }

    public long[] getLongArray(int n) {
      long[] temp = new long[n];
      for (int i = 0; i < n; i++) temp[i] = getLong();
      return temp;
    }
  }
}
