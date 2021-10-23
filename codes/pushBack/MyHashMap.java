/**
 * Design HashMap without using java collenctions.
 */

public class MyHashMap {

  public Node[] map = null;
  public int size = 0;

  public class Node {

    int key = -1;
    int value;
    Node next;

    public Node() {}

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public MyHashMap(int size) {
    this.size = size;
    map = new Node[size];

    for (int i = 0; i < size; i++) {
      map[i] = new Node();
    }
  }

  public void put(int key, int value) {
    int hash = getHash(key);
    Node node = map[hash];

    if (node.key == -1) {
      map[hash] = new Node(key, value);
    } else {
      while (node != null) {
        if (node.key == key) {
          node.value = value;
          return;
        }
        node = node.next;
      }
    }
  }

  public int get(int key) {
    int hash = getHash(key);
    Node node = map[hash];

    while (node != null) {
      if (node.key == key) {
        return node.value;
      }
      node = node.next;
    }
    throw new IllegalArgumentException("key not exists.");
  }

  public int getHash(int key) {
    return key % size;
  }

  public static void main(String[] args) {
    MyHashMap hm = new MyHashMap(10);

    hm.put(3, 20);
    hm.put(54, 22);
    hm.put(2, 44);
    hm.put(12, 78);

    System.out.println(hm.get(2));

    hm.put(2, 22);

    System.out.println(hm.get(55));
  }
}
