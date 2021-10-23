import java.util.*;

class Test {

  static Map<String, List<String>> adj = new HashMap<>();

  public static void main(String[] args) {
    String[][] str = {
      { "A", "B" },
      { "B", "C" },
      { "C", "D" },
      { "B", "D" },
      { "D", "E" },
      { "E", "D" },
    };

    Map<String, List<String>> adj = new HashMap<>();

    for (String[] s : str) {
      if (!adj.containsKey(s[0])) {
        adj.put(s[0], Arrays.asList(s[1]));
      } else {
        adj.get(s[0]).add(s[1]);
      }
    }

    List<String> result = new ArrayList<>();

    paths("A", new HashSet<>(), new ArrayList<>(), result);

    for (String a : result) {
      System.out.println(a);
    }
  }

  static void paths(
    String current,
    Set<String> visited,
    List<String> path,
    List<String> result
  ) {
    boolean changed = false;

    for (String s : adj.get(current)) {
      if (!visited.contains(s)) {
        changed = true;
        List<String> temp = new ArrayList<>();
        temp.addAll(path);
        temp.add(s);

        Set<String> te = new HashSet<>();
        te.addAll(visited);
        te.add(s);
        paths(s, te, temp, result);
      }
    }

    if (!changed) {
      int midLen = path.size() / 2;

      result.add(path.get(midLen));
    }
  }
}
