import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 25 | [ Friday ]
 * Time: 15 : 53 : 55 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class BinaryTreeLevelOrderTraversalI {

    public class TreeNode {
        int val; 
        TreeNode left; 
        TreeNode right;

        TreeNode(int x ) { val = x ;};
    }

    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode lastNode = root;
        TreeNode lastUpdated = null;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tlist = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()) {

            TreeNode t = q.peek();
            tlist.add(t.val);
            q.remove();

            if(t.left != null ) {
                q.add(t.left);
                lastUpdated = t.left;
            }

            if(t.right != null ) {
                q.add(t.right);
                lastUpdated = t.right;
            }

            if(lastNode == t) {
                if(lastUpdated != null ) {
                    lastNode = lastUpdated;
                }
                result.add(tlist);
                tlist = new ArrayList<>();
            }

        }

        Collections.reverse(result);;
        
        return result;
    }




    public void solve() throws Exception {
       



    } // End

    public BinaryTreeLevelOrderTraversalI() throws Exception {
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
            new BinaryTreeLevelOrderTraversalI();
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
