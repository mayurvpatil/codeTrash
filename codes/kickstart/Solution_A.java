import static java.lang.System.exit;

import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 April 19 | [ Monday ]
 * Time: 06 : 36 : 59
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class Solution_A {

  public void solve() throws Exception {
    int n = in.getInt();
    char[] s = in.getLine().toCharArray();
    int[] aa = new int[s.length];

    int i = 0;
    for (char c : s) {
      aa[i++] = c - 'A';
    }

    int re[] = new int[s.length];
    re[0] = 1;
    for (i = 1; i < aa.length; i++) {
      if (aa[i - 1] < aa[i]) {
        re[i] = re[i - 1] + 1;
      } else {
        re[i] = 1;
      }
    }

    for (int r : re) System.out.print(r + " ");
  } // End

  public Solution_A() throws Exception {
    boolean isMultipleTestCases = true;
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);

    if (isMultipleTestCases) {
      int t = in.getInt();
      for (int i = 1; i <= t; ++i) {
        System.out.print("Case #" + i + ": ");
        solve();
        System.out.println("");
      }
    } else {
      solve();
    }
    out.close();
  }

  public static void main(String[] args) {
    try {
      new Solution_A();
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
