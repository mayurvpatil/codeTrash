import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 16 | [ Wednesday ]
 * Time: 13 : 43 : 27 
 * 
 * CodeChef solution
 */

class Longest_Palindrome {


    public boolean isPalindrome(String s) {
        int start=0, end = s.length()-1;
        while(start<end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    String res = "";
    public void foo(String curr, int i, String s) {

        if(isPalindrome(curr)) {
            if(curr.length() > res.length()) {
                
                res = new String(curr);
            }
        }

        if(i+1<=s.length()) {
        foo(curr, i+1, s);
        foo(new String(curr.concat(s.charAt(i)+"")), i+1, s);
        }

    }

    public void solve() {
        in.getInt();
        String s = in.getString();
        foo("", 0, s);
        out.println(res.length()    );
        out.println(res);

    } // End

    public Longest_Palindrome() throws Exception {
        boolean isMultipleTestCases = false;
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        if (isMultipleTestCases) {
            int t = in.getInt();
            for (int i = 1; i <= t; ++i) {
                //out.print("Case #" + i + ": ");
                solve();
            }
        } else {
            solve();
        }
        out.close();
    }

    public static void main(String[] args) {
        try {
            new Longest_Palindrome();
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
