import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 10 | [ Sunday ]
 * Time: 03 : 02 : 28 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class WordSearch {

     
    private int n = 0 ; 
    private int m = 0 ;
        
    private char[] w = null;
    
    public boolean isvalid(char[][] board, int i, int j, int a) {
        
        if(a == w.length) return true;
        
        if( i+1 < n && board[i+1][j] == w[a] ) {
                board[i][j] = '1';
                boolean result = isvalid(board, i+1, j, a+1);
                if(result) return true;
        } 
        if( i-1 >= 0 && board[i-1][j] == w[a]) {
                board[i][j] = '1';
                boolean result = isvalid(board, i-1, j , a+1);
                if(result) return true;
        } 
        if ( j + 1 < m && board[i][j+1] == w[a]) {
                board[i][j] = '1';
                boolean result = isvalid(board, i , j+1, a+1) ;
                if(result) return true;
        } 
        
        if (j - 1 >= 0 && board[i][j-1] == w[a]) {
                board[i][j] = '1';
                boolean result = isvalid(board, i, j-1, a+1);
                if(result) return true;
        }
        return false;
    }
  
    public boolean exist(char[][] board, String word) {
        
        n = board.length;
        m = board[0].length;
        w = word.toCharArray();
        
        for(int i = 0 ; i < n; i++ ) {
            for(int j = 0 ; j < m; j++) {
                if(board[i][j] == w[0]) {

                    char[][] cpy =  Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
                    if(isvalid(cpy, i , j, 1)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }

    public void solve() throws Exception {

        char[][] aa = new char[][] {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(exist(aa, "AAB"));
       
    } // End

    public WordSearch() throws Exception {
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
            new WordSearch();
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
