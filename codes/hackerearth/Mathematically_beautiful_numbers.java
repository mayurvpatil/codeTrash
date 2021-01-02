import static java.lang.System.exit;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 02 | [ Saturday ]
 * Time: 11 : 03 : 54 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Mathematically_beautiful_numbers {

    boolean isPossible(List<Long> list , int i, Long sum, Long a) {

       // out.println(sum );

        if(sum.equals(a)) return true;

        if(i>list.size()-1) return false;
        if(sum.compareTo(a) > 0) return false;
         
        return isPossible(list, i+1, sum, a) || isPossible(list, i+1, (sum + list.get(i)), a);

    }

    public void solve() throws Exception {

        List<Long> dp = new ArrayList<>();
        
        Long a = in.getLong();
        int k = in.getInt();

        Long pow = 1l;
        
        while( pow <= a) {
            dp.add(pow);
            pow = dp.get(dp.size()-1) * k;
        }

        if(isPossible(dp, 0, 0l, a)) {
            out.println("YES");
        } else {
            out.println("NO");
        }


    
        
    } // End

    public Mathematically_beautiful_numbers() throws Exception {
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
            new Mathematically_beautiful_numbers();
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

        public Long getLong() {
            return Long.parseLong(getString());
        }

        public int[] getIntArray(int n) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++)
                temp[i] = getInt();
            return temp;
        }

        public Long[] getLongArray(int n) {
            Long[] temp = new Long[n];
            for (int i = 0; i < n; i++)
                temp[i] = getLong();
            return temp;
        }
    }
}
