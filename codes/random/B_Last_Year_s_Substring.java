import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 *         Date: 2020 December 16 | [ Wednesday ] Time: 01 : 57 : 29
 */

public class B_Last_Year_s_Substring {

    public void solve() {

            int n = in.getInt();
            char[]s =in.getLine().toCharArray();
            char[]need= new char[]{'2','0','2','0'};
            boolean ans =false;
            for (int i =0;i<=4;i++){
                int suf= 3;
                boolean here=true;
                for (int k =0;k<i;k++)
                    here&=s[k]==need[k];
                for (int j = s.length-1;j>=0&&suf>=i;j--)
                    here&=s[j]==need[suf--];
                ans|=here;
            }
            out.println(ans?"YES":"NO");

    } // End

    public B_Last_Year_s_Substring() throws Exception {
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
            new B_Last_Year_s_Substring();
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

        public String getLine() {
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
            return Integer.parseInt(getLine());
        }

        public long getLong() {
            return Long.parseLong(getLine());
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
