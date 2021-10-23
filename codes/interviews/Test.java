public class Test {

    /*

        consider 

        token-  worsds as files
                store word in ds 
                
                parsing multiple files; 

        list of file as input 
        update ds 
        count of word. 

        if requred to change lookup 

        ex: "abc abc xyz " 

        Array, List

        approach : 

            Map<String, Integer> = new 

            - Trie      
            
            0

        a     x 

    
    b           y
                        z 
                        true;
                        count = 1;

    c = true
        count = 2; 


    O(n)

    Map<Strin, Integer>  
    Map<Integer, List<String>> freqMap =


    /// 
    Doubly LL 
    Priority Queue 


    Add()
    get()

    FIFO
    priority - 

    Queue - Linked 
    Linked List - 


    Doubly linkedlist
    
    (1,1) ->  (1,3) ->  (2,1) -> (5, 2) -> null

    (1, 1)
    (1, 3) = (1,3) -> (1,1)


    1,3
    5,2
    1,2
    2,1


    */




    class Node {
        int val;
        int priority;

        Node next;
        Node pre;

        Node(int val , int prio) {
            this.val = val;
            this.priority = prio;
        }

    }

    Node head = null;
    Node tail = null;

    // (1, 3) (1,2) (1, 1)  -> (1,2)

    // top 
    // ps - 

    private void add(int val, int priority) {



        if(head == null ) {
            head = new Node(val, priority);
            tail = head;
        }

        
        while(head.next != null) {



        }

/*

        // 
        // 

        if(head.priority > priority) {
            Node temp = head;
            head = new Node(val, priority);
            head.next = temp;
            tail = temp;
        } else {

            tail.next = new Node(val, priority);


        }

        heap 

*/


    }




    
    
}
