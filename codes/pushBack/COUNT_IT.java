import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 17 | [ Thursday ]
 * Time: 19 : 05 : 34 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class COUNT_IT {

    List<List<Integer>> dp;
    int n;

    void foo(int c, List<Integer> cu) {

        if(c==n) {
            Collections.sort(cu);
            if(!dp.contains(cu)) {
                dp.add(cu);
            }
            return;
        }

        if(c>n) return;
        
        
        List<Integer> a= new ArrayList<>(cu);
        a.add(1);
        List<Integer> ab= new ArrayList<>(cu);
        ab.add(2);

        foo(c+1, a);
        foo(c+2, ab);

    }

    public void solve() throws Exception {
       
        dp = new ArrayList<>();
             n = in.getInt();

             foo(0, new ArrayList<>());

             List<List<Integer>> aaa = dp;

             out.println(dp.size());



    } // End

    public COUNT_IT() throws Exception {
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
            new COUNT_IT();
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
