import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 02 | [ Saturday ]
 * Time: 09 : 56 : 15 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class MaximumProfit {

    public void solve() throws Exception {

        int n = in.getInt();
        int k = in.getInt();

        Integer a[] = new Integer[n];

        for(int i = 0 ; i < n ; i++ ) {
            a[i] = Integer.valueOf(in.getInt());
        }
        
        Set<Integer> s = new  HashSet<>(Arrays.asList(a));
        PriorityQueue<Integer> heap =  new PriorityQueue<Integer>(Collections.reverseOrder()); 

        for(Integer v : s) {
            heap.add(v);
        }

        int sum = 0;

        for(int i = 0 ; i < k ; i++) {
            
            Integer aa = heap.peek();

            if(aa != null ) {
                heap.remove();
            } else {
                break;
            }
            sum+= aa;

        }

        out.println(sum);

       
    } // End

    public MaximumProfit() throws Exception {
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
            new MaximumProfit();
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
