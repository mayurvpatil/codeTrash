import java.util.*;

public class MapExamples {

  public MapExamples() {
    Map<String, Integer> map = new HashMap<>();

    map.put("1", 1);
    map.put("88", 88);
    map.put("5", 5);
    map.put("34", 34);

    System.out.println("before : " + map);

    Collections.sort(map);

    System.out.println("after : " + treeMap);
  }

  public static void main(String[] args) {
    new MapExamples();
  }
}
