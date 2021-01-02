import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 02 | [ Saturday ]
 * Time: 17 : 12 : 17 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class ProductofArrayExceptSelf {


    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i = 1; i < nums.length; i++ ) {
            result[i] = result[i-1] * nums[i-1];
        }

        int last = 1 ;
        

        for(int i= nums.length-1; i >= 0 ; i-- ) {
            result[i] = result[i] * last;
            last *= nums[i]; 
        }
        
        return result;
    }

    public void solve() throws Exception {

        int[] a = new int[]{4,3,2,1,2};


        int[] r = productExceptSelf(a);

        for(int aa : r) {
            out.print(aa + " ");
        }



    } // End

    public ProductofArrayExceptSelf() throws Exception {
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
            new ProductofArrayExceptSelf();
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
