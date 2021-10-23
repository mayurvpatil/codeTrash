import static java.lang.System.exit;

import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 May 16 | [ Sunday ]
 * Time: 11 : 46 : 56
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class similarityIndex {

  Map<Integer, String> dp = new HashMap<>();

  public int findSimilarityIndex(String s) {
    if (s.length() == 0) return 0;

    char last = s.charAt(0);
    boolean isChanged = false;

    int count = 0;

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (last == c) {
        continue;
      } else {
        if (isChanged) {
          count++;
          last = c;
          isChanged = false;
        } else {
          last = c;
          isChanged = true;
        }
      }
    }

    if (isChanged) return count + 1;
    return count;
  }

  public int maxIndex(String s, int kValue) {

    // ereerr
    int len = s.length();

    int max = Integer.MIN_VALUE;
    String maxstr = "";

    for (int i = 0; i <= len; i++) {
      for (int j = i + 1; j <= len; j++) {
        StringBuilder sub = new StringBuilder(s.substring(i, j));
        String tmpStr =
          s.substring(0, i) +
          sub.reverse().toString() +
          s.substring(j, s.length());

        int temp = findSimilarityIndex(tmpStr);

        if (temp > max) {
          System.out.println(" i : " + i + " j : " + j + " String : " + tmpStr);
          max = temp;
          maxstr = tmpStr;
        }
      }
    }

    dp.put(kValue, maxstr);
    return max;
  }

  public void solve() throws Exception {
    String str = "ereerr";
    int q = 2;
    int[] qq = new int[] { 0, 3 };

    dp.put(0, str);

    for (int query : qq) {
      int last = 0;
      if (!dp.isEmpty()) {
        List<Integer> keys = new ArrayList<Integer>(dp.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
          if (keys.get(i) < query) {
            last = i;
          } else {
            break;
          }
        }
      }

      int result = 0;
      for (int i = last; i < query; i++) {
        result = maxIndex(dp.get(i), i + 1);
      }

      System.out.println(result);
    }
  } // End

  public similarityIndex() throws Exception {
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
      new similarityIndex();
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
