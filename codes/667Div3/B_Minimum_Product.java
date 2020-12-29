import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 18 | [ Friday ]
 * Time: 05 : 36 : 43 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */
// https://codeforces.com/contest/1409/problem/B

public class B_Minimum_Product {

    public void solve() throws Exception {

        int a = in.getInt(), b = in.getInt(), x = in.getInt(), y = in.getInt(), n = in.getInt();

        for(int i = 0 ; i < n ; i++) {

            if(!(a>x || b> y)) break;

            if(a>x && b > y) {

                if(((a-1) * b) > (a * (b-1)) ) {
                    a--;
                } else {
                    b--;
                }
            }

            if(a>x && b<=y) {
                a--;
            }

            if(b>y && a<=x) {
                b--;
            }

        }

        out.println(a*b);
       


    } // End

    public B_Minimum_Product() throws Exception {
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
            new B_Minimum_Product();
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
