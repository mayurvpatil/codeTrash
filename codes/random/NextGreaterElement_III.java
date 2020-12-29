import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 24 | [ Thursday ]
 * Time: 03 : 20 : 52 
 */

/**
 * Public - CodeForces No modifier - CodeChef
 */

public class NextGreaterElement_III {

    public Long foo(StringBuilder str, Long min, int inputN) {  // recursive function

        boolean needIteration = false; // base case, this will decide if we need more recursion required or not

        for (int i = 0; i < str.length() - 1; i++) {      // iterating over string length, which is Log(n) mostly; 
            for(int j = i+1; j < str.length(); j++) {     // Overall TC is (Log(n))^2

                StringBuilder t = new StringBuilder(str);     // make sure to create new string instance otherwise original string will get update
                char temp = t.charAt(i);
                t.setCharAt(i, t.charAt(j));                // swap char at i and j
                t.setCharAt(j, temp);

                Long newVal = Long.parseLong(t.toString()); // converto to Long and to check condition
                                                            // used Long to prevent Integer overflow.

                if (newVal < min && newVal > inputN && newVal < Integer.MAX_VALUE) {     // if condition is valid
                    min = newVal;                                                   // update new min 
                    updated = true;                                                 // updated value, ie -1 is not answer
                    needIteration = true;                                           // defines we need more recursion.
                }
            }
        }

        if(needIteration) {
            return foo(new StringBuilder(min.toString()), min, inputN);  // recursive call, with new min value.
        } else {
            return min;
        }

        /*
            Consider, input = 21891

            first   foo() call min = 21981, which is not valid answer
            second  foo() call min = 21918, which is valid but last recursion again
            third   foo() call min is unchanged and needIteration remaind unchanged terminates recursion and return 21918.

        */

    }

    boolean updated = false;            // it global, used to decide if valid answer is available or not. if not return -1.
    public int nextGreaterElement(int n) {

        Long result = foo(new StringBuilder(Integer.toString(n)) , Long.MAX_VALUE, n);
        if (updated)
            return  Long.valueOf(result).intValue();
        else
            return -1;
    }

    public void solve() throws Exception {

        int n = 1999999999;

        System.out.println(nextGreaterElement(n));

    } // End

    public NextGreaterElement_III() throws Exception {
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
            new NextGreaterElement_III();
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
