class MyHashMap {

  public class Node {

    int key;
    int value;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  int hashSize = 10;
  Node[] table = null;

  public MyHashMap() {
    table = new Node[hashSize];
  }

  public static void main(String[] args) {
    MyHashMap a = new MyHashMap();
    a.put(1, 1);
    a.put(2, 2);
    System.out.println(a.get(1));
    System.out.println(a.get(3));
    a.put(2, 1);
    System.out.println(a.get(2));
    a.remove(2);
    System.out.println(a.get(2));
  }

  private int getHash(int key) {
    return key % hashSize;
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hash = getHash(key);

    if (table[hash] == null) {
      table[hash] = new Node(key, value);
    } else {
      Node temp = table[hash];
      Node pre = null;

      while (temp != null) {
        if (temp.key == key) {
          temp.value = value;
          return;
        }
        pre = temp;
        temp = temp.next;
      }

      pre.next = new Node(key, value);
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    int hash = getHash(key);

    Node temp = table[hash];

    while (temp != null) {
      if (temp.key == key) return temp.value;
      temp = temp.next;
    }

    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hash = getHash(key);

    if (table[hash] == null) return;

    Node temp = table[hash];
    Node pre = null;

    while (temp != null) {
      if (temp.key == key) {
        if (pre == null) {
          table[hash] = null;
          return;
        }

        pre.next = temp.next;
      }

      pre = temp;
      temp = temp.next;
    }
  }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
