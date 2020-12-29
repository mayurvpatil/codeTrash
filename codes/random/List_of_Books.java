import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 16 | [ Wednesday ]
 * Time: 11 : 54 : 21 
 * 
 * CodeChef solution
 */

class List_of_Books {

    public void solve() {

        int m = in.getInt();
        List<Integer> b = new ArrayList<>();

        for(int i = 0 ; i < m ; i++ ) {
            b.add(in.getInt());
        }

        int a = in.getInt();

        for(int i = 0 ; i < a; i++) {

            int aa = in.getInt();
            aa--;
            
            if(b.get(aa) > 0) {
                out.println(b.get(aa));    
                b.remove(aa);
            }
        }


    } // End

    public List_of_Books() throws Exception {
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
            new List_of_Books();
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
