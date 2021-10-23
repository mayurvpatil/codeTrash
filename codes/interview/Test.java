import java.util.HashSet;

public class Test {

  /*

Given a graph with N number of nodes (numbered from 1 to N) and two arrays A and B, 
where A has all the source nodes and B has their respective destination nodes 
(i.e there's an edge from A[i] to B[i]). 
Check whether the following path exists 1 → 2 → ... → N-1 → N

    */

  private boolean findPath(int[] source, int[] destinations, int n) {
    // List[] graph = new List<Integer>()[n+1];

    /*
        [1, 2, 3]
        [2, 3, 4]

        2, 2, 4
        3, 1, 1

        2,

        N = nodes 
        len = source.length

        tc = O(max( N , len))
        sc = O(N)


        */

    HashSet<Integer> found = new HashSet<>();

    for (int i = 0; i < source.length; i++) {
      if (source[i] == destinations[i] - 1) {
        found.add(source[i]);
      }

      if (source[i] - 1 == destinations[i]) {
        found.add(destinations[i]);
      }
    }

    for (int i = 1; i < n - 1; i++) {
      if (!found.contains(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {}
}
