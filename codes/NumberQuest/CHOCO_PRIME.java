import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 23 | [ Wednesday ]
 * Time: 17 : 30 : 28 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class CHOCO_PRIME {

    public void solve() throws Exception {

        String n = in.getLine();
        char[] a = n.toCharArray();

        int aa = Integer.parseInt(n);
        boolean[] dp = new boolean[aa+1];
        Arrays.fill(dp, true);

        int start =0 ; 
        int end = a.length-1;
        while(start<end) {
            if(a[start] != a[end]) {
                out.println("No");
                return;
            }
            start++;
            end--;
        }

        dp[1] = false;
        for(int i = 2; i<= (int)Math.sqrt(aa); i++ ) {
                if(dp[i]) {
                    int t = 2;
                    for(int j = i*t; j < dp.length; j = i*t) {
                        t++;
                        dp[j] = false;
                    }
                }
        }

        if(dp[aa]) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    
    } // End

    public CHOCO_PRIME() throws Exception {
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
            new CHOCO_PRIME();
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
