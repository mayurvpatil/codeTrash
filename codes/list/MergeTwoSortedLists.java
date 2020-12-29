import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 24 | [ Thursday ]
 * Time: 06 : 26 : 06 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class MergeTwoSortedLists {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode createLL(int[] array) {

    ListNode head = new ListNode(array[0]);
    ListNode temp = head;

    for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
    }
    return head;
}

    public ListNode mergeTwoLists(ListNode a, ListNode b) {


        ListNode result = null;
        ListNode itr = null ;

        while (a != null || b != null) {

            if(a == null && b != null) {
                itr.next = new ListNode(b.val);
                itr = itr.next;
                b = b.next;
                continue;
            } 

            if(b == null && a != null) {
                itr.next = new ListNode(a.val);
                itr = itr.next;
                a = a.next;
                continue;
            }



            if(a.val<= b.val) {
                if(itr == null ) {
                    result = new ListNode(a.val);
                    itr = result ;
                } else {
                    itr.next = new ListNode(a.val);
                    itr = itr.next;
                }
                a = a.next;
            } else {
                if(itr == null ) {
                    result = new ListNode(b.val);
                    itr = result;
                } else {
                    itr.next = new ListNode(b.val);
                    itr = itr.next;

                }
                b = b.next;
            }
        }

        

        return result;

    }

    public void solve() throws Exception {

        int[] a = new int[] {8} ;
        int[] b = new int[] {1,3,4,1,2,4};

        ListNode aa = mergeTwoLists(createLL(a), createLL(b));

        while(aa != null ) {
            out.print(aa.val + " ");
            aa = aa.next;
        }


        
    } // End

    public MergeTwoSortedLists() throws Exception {
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
            new MergeTwoSortedLists();
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
            for (int i = 0; i < n; i++)
                temp[i] = getInt();
            return temp;
        }

        public long[] getLongArray(int n) {
            long[] temp = new long[n];
            for (int i = 0; i < n; i++)
                temp[i] = getLong();
            return temp;
        }
    }
}
