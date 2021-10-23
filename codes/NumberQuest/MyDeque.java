import java.util.*;

/***
 * Design Deque using Collections LinkedList.
 * follow up : remore LinkedList and implement doubly-linked list from scratch.
 */

public class MyDeque {

  LinkedList<Integer> deque = null;

  public MyDeque() {
    deque = new LinkedList<>();
  }

  public void add(int value) {
    deque.addFirst(value);
  }

  public int getFirst() {
    return deque.removeFirst();
  }

  public int getLast() {
    return deque.getLast();
  }

  public void insertAfter(int node, int value) {
    deque.add(deque.indexOf(node) + 1, value);
  }

  public static void main(String[] args) {
    MyDeque md = new MyDeque();

    md.add(3);
    md.add(5);
    md.add(2);
    md.add(8);
    md.insertAfter(2, 7);

    md.deque.stream().forEach(System.out::print);
    System.out.println("---");
    System.out.println(md.getFirst());
    System.out.println(md.getLast());
  }
}
