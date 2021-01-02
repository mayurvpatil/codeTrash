import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 30 | [ Wednesday ]
 * Time: 05 : 11 : 47 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class MergeTwoBinaryTrees {

    public class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public void merge(TreeNode a , TreeNode b , TreeNode result) {

        if(a == null && b == null ) return ;
        
        int sum = 0;
        if(a != null ) {
            sum += a.val;
        } 

        if(b != null ) {
            sum += b.val;
        } 

        result.val = sum;

        // recursion

        if((a != null && a.left != null) || ( b!= null  && b.left != null)) {

            TreeNode newNode = new TreeNode();
            result.left = newNode;

            if((a != null && a.left != null) && ( b!= null  && b.left != null)) {
                merge(a.left, b.left, result.left);
            } 
            else if (a!= null && a.left != null ) {
                merge(a.left, null, result.left);
            } else {
                merge(null, b.left, result.left);
            }
        }

        if((a != null && a.right != null) || ( b!=null && b.right != null ) ) {
            TreeNode newNode = new TreeNode();
            result.right = newNode;

            if((a != null && a.right != null) && ( b!= null  && b.right != null)) {
                merge(a.right, b.right, result.right);
            } 
            else if (a!= null && a.right != null ) {
                merge(a.right, null, result.right);
            } else {
                merge(null, b.right, result.right);
            }
            
        }

    }


     public TreeNode mergeTrees(TreeNode a, TreeNode b) {

        if(a == null && b == null ) return a;

        if(a == null && b!=null ) return b;
        if(a!= null &&  b == null) return a;

        TreeNode result = new TreeNode();

        merge(a,b,result);
        return result;

    }

    public void solve() throws Exception {



    } // End

    public MergeTwoBinaryTrees() throws Exception {
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
            new MergeTwoBinaryTrees();
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
