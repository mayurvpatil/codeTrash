import static java.lang.System.exit;
/**
 * @author mayurvpatil
 *
 * Date: 2021 April 13 | [ Tuesday ]
 * Time: 00 : 57 : 23
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

import static java.lang.System.exit;

import java.io.*;
import java.io.*;
import java.util.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 April 13 | [ Tuesday ]
 * Time: 00 : 57 : 25
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class SortList {

  public class ListNode {

    int val;
    ListNode next;
  }

  public void solve() throws Exception {
  

    Comparator<ListNode> cmp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    };

    Queue<ListNode> minHeap = new PriorityQueue<ListNode>(Collections.reverseOrder(cmp));

    for(ListNode l : )



  } // End

  public SortList() throws Exception {
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
      new SortList();
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

public class SortList {

  public void solve() throws Exception {} // End

  public SortList() throws Exception {
    boolean isMultipleTestCases = true;
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
      new SortList();
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
