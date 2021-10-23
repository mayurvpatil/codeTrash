import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 08 | [ Friday ]
 * Time: 00 : 59 : 38 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        
        int max = 0 ;
        Map<Character,Integer> map = new HashMap<>();

        int i = 0 ; 
        for(int j  = 0 ; j < s.length(); j++) {

            Character c = s.charAt(j);

            if(map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }

            if(max < (j - i + 1)) {
                max = (j - i + 1);
            }

            map.put(c, j);

        }

        return max;

    }


    public int lengthOfLongestSubstringaa(String s) {

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        
        Map<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        
        int start = 0;
        int i = 0 ;

        int lastUpdated = 0 ;
        for( i = 0; i< s.length(); i++) {

            
                if(map.containsKey(s.charAt(i))) {
                    
                    int newCount;
                    if(lastUpdated > start ) {
                        newCount = i - lastUpdated ;
                    } else {
                        newCount = i - start;
                    }

                    if( newCount > max) {
                        max = newCount ;
                    }
                    start = map.get(s.charAt(i)) + 1;
                    lastUpdated = i;
                    map.put(s.charAt(i), i );
                } else {
                    map.put(s.charAt(i), i);
                }
        }

        if(max == 0 && s.length() != 0 ) return s.length();

        if(lastUpdated < s.length()) {
            return max + (s.length() - lastUpdated);
        }
        
        return max ;

        
    }
    

    public void solve() throws Exception {

        System.out.println(lengthOfLongestSubstring("sdfasaasdafsd"));
       
    } // End

    public LongestSubstringWithoutRepeatingCharacters() throws Exception {
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
            new LongestSubstringWithoutRepeatingCharacters();
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
