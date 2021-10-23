import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 06 | [ Wednesday ]
 * Time: 00 : 35 : 31 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class RemoveDuplicatesFromSortedListII {

    public ListNode createLL(int[] array) {

        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
    
        for (int i = 1; i < array.length; i++) {
                temp.next = new ListNode(array[i]);
                temp = temp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null ) return head;
        ListNode itr = null;
        ListNode newhead = null;
        
        while(head != null ) {
            ListNode last = head;
            int pre = head.val;
            int count = 0 ;
            head = head.next;

            while(head != null && head.val == pre) {
                count++;
                head = head.next;
            }
            
            if(count == 0) {
                if(itr == null ) {
                    itr = last;
                    newhead = last;
                    itr.next = null;
                } else {
                    itr.next = last;
                    itr = itr.next;
                    itr.next = null;
                }
            }
        }
        return newhead;
    }

    public void solve() throws Exception {


        int[] b = new int[] {1,1};

        ListNode aa = deleteDuplicates(createLL(b));

        while(aa != null ) {
            out.print(aa.val + " ");
            aa = aa.next;
        }

        
       
    } // End

    public RemoveDuplicatesFromSortedListII() throws Exception {
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
            new RemoveDuplicatesFromSortedListII();
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
