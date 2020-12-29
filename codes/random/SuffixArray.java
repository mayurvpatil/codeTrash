import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 24 | [ Thursday ]
 * Time: 12 : 45 : 21 
 */

/**
 * Public - CodeForces No modifier - CodeChef
 */
class SuffixArray {

    public void solve() throws Exception {

        String a = in.getLine();
        String b = in.getLine();

        String last = "";
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {

                StringBuilder as = new StringBuilder(a.substring(i, j)).reverse();
                if (!as.isEmpty()) {
                    if (b.contains(as)) {
                        last = as.toString();
                        continue;
                    } else {
                        if (!last.isEmpty()) {
                            count++;
                            b = b.replace(last, "");
                            last = "";
                        } else {
                            b = b.replace(last, "");
                            count++;
                        }
                    }
                }
            }
        }

        out.println(count + (b.length()));

    } // End

    public SuffixArray() throws Exception {
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
            new SuffixArray();
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
