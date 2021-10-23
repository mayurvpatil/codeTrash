import java.util.HashMap;
import java.util.Map;

public class ABC {

  public static void main(String[] args) {
    Map<Emp, Integer> map = new HashMap<>();

    map.put(new Emp(1, 1, 1), 1);
    map.put(new Emp(2, 2, 2), 2);
    map.put(new Emp(3, 3, 3), 3);
    map.put(new Emp(4, 4, 4), 4);
    map.put(new Emp(5, 5, 5), 5);

    System.out.println(map.get(4));
  }
}
