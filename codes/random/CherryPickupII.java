import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 20 | [ Sunday ]
 * Time: 00 : 41 : 38 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

 // Problem statement : https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3571/

public class CherryPickupII {

    public int resolve(int[][] g , int i , int j , int k, int c, Integer[] jj , Integer[] kk) {

        if(i>g.length-1 || j<0 || j>g[i].length-1 || k<0 || k>g[i].length-1) {
            return c;
        }

        if(j == k ) {
            c += g[i][j];
        } else {
            c += g[i][j] + g[i][k];
        }

        int max = Integer.MIN_VALUE;
        int ma = 0;
        int mb = 0;

        for(int a = j-1; a <= j+1; a++) {
            for(int b = k-1; b <= k+1; b++) {
                    jj[i-1] = a;
                    kk[i-1] = b;
                    int rc = resolve(g, i+1, a, b, c, jj, kk);
                    if(rc > max) {
                        max = rc;
                        ma = a;
                        mb = b;
                    }
            }
        }


        jj[i-1] = ma;
        kk[i-1] = mb;

        out.print("max : " + max +  " i : " + i + " a : " );
        for (Integer l : jj) if(l!=null) out.print(l + " ");
        out.print( " b : " );
        for (Integer l : kk) if(l!=null) out.print(l + " ");
        out.println();

        return c;

    }


    public void solve() throws Exception {

      // sample 1
      int[][] g = new int[][] {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
      
      //sample 2 
      //int[][] g = new int[][] {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};


      // ignore this stupid stuff
      Integer[] aaa = new Integer[g.length-1];
      Arrays.fill(aaa, null);
      Integer[] aaaaa =  new Integer[g.length-1];
      Arrays.fill(aaaaa, null);

        int result = resolve(g, 1, 0, g[0].length-1, g[0][0] + (g[0][g[0].length - 1]), aaa, aaaaa);

        System.out.println(result);

    } // End

    public CherryPickupII() throws Exception {
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
            new CherryPickupII();
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