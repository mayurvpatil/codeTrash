import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 17 | [ Thursday ]
 * Time: 00 : 21 : 02 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class SetMatrixZeroes {
    

    public void setZeroes(int[][] matrix) {
        
      
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> c = new ArrayList<>();
        List<Integer> found = new ArrayList<>();
        
        for(int i = 0; i < n; i++ ) {
            for(int j = 0 ; j < m ; j++) {
                
                if(matrix[i][j] == 0) {
                    System.out.print(j);
                    found.add(j);
                    c.add(j);
                }
                
            }
            
            if(!found.isEmpty()) {
                matrix[i] = new int[n+1];
            }
            found.clear();
        }
        
        
        for(int a : c) {
            for(int i = 0 ; i < m-1; i++) {
                System.out.print(i);
                matrix[i][a] = 0;
            }
        }
        
    }


    public void solve() throws Exception {

        int[][] aa = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(aa);
       
    } // End

    public SetMatrixZeroes() throws Exception {
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
            new SetMatrixZeroes();
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
