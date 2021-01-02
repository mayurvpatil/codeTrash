import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 01 | [ Friday ]
 * Time: 07 : 38 : 23 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class BackspaceStringCompare {


    public boolean backspaceCompare(String a , String b) {

        int ap = a.length()-1;
        int bp = b.length()-1;

        while(ap >= 0 || bp >= 0) {

            if(ap > 0) {
            if( a.charAt(ap) == '#') {
                int count = 0 ; 
                while(a.charAt(ap) == '#') {
                    count++;
                    ap--;
                }
                ap -= count;
                continue;
            }
        }

        if(bp > 0) {
            if( b.charAt(bp) == '#') {
                int count = 0;
                while(b.charAt(bp) == '#') {
                    count++;
                    bp--;
                }
                bp -= count;
                continue;
            }
        }
             
        if(ap>=0 && bp >= 0) {
            if(a.charAt(ap) != b.charAt(bp)) { 
                return false;
            }
        }
            ap--;
            bp --;
        
    }



        if(ap <= 0 && bp <= 0 ) return true;
        else return false;

    }
    



     public boolean backspaceCompareRegex(String S, String T) {

        Pattern pattern = Pattern.compile("[a-z]#", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(S);

        while( matcher.find() )  {
            S = S.replaceAll("[a-z]#", "");
            matcher = pattern.matcher(S);
        }

        matcher = pattern.matcher(T);
        while( matcher.find() ) {
            T = T.replaceAll("[a-z]#", "");
            matcher = pattern.matcher(T);
        }

        S = S.replaceAll("#", "");
        T = T.replaceAll("#", "");

        return S.equals(T);
    }

    public void solve() throws Exception {
        

        System.out.print(backspaceCompare("ab##", "c#d#"));

    } 

    public BackspaceStringCompare() throws Exception {
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
            new BackspaceStringCompare();
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
