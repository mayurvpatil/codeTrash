import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 18 | [ Monday ]
 * Time: 23 : 27 : 45 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class MaxNumberOfKSumPairs {


    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int a : nums ) {

            if(a >= k ) continue;
            
            int find = k - a;
            if(map.containsKey(find)) {
                
                if(map.get(find) == 1) map.remove(find);
                else {
                    map.put(find, map.get(find) - 1);
                }
                count++;
            } else {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            
        }
        
        return count;
        
    }

    public void solve() throws Exception {

        int[] aa = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;

        System.out.println(maxOperations(aa, k));
       
    } // End

    public MaxNumberOfKSumPairs() throws Exception {
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
            new MaxNumberOfKSumPairs();
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
