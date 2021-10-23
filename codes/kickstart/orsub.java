import static java.lang.System.exit;

import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 May 16 | [ Sunday ]
 * Time: 09 : 07 : 28
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class orsub {

  public void solve() throws Exception {
    int[] arr = new int[] { 1, 2, 3 };
    int len = arr.length;


    

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        int temp = arr[i];
        for (int a = i + 1; a <= j; a++) {
          temp |= arr[a];
        }
        System.out.println("i : " + i + " , j =  " + j);
        list.add(temp);
      }
    }

    Collections.sort(list);

    for (Integer aa : list) {
      System.out.print(aa + " ");
    }
  } // End

  public orsub() throws Exception {
    boolean isMultipleTestCases = false;
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);

    if (isMultipleTestCases) {
      int t = in.getInt();
      for (int i = 1; i <= t; ++i) {
        solve();
      }
    } else {
      solve();
    }
    out.close();
  }

  public static void main(String[] args) {
    try {
      new orsub();
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
