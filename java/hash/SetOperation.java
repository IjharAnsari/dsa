import java.util.HashSet;
import java.util.List;

/* 
 * Union and Intersection of two linked lists
 * 
 * Input:
   List1: 10 -> 15 -> 4 -> 20
   List2: 8 -> 4 -> 2 -> 10
   Output:
   Intersection List: 4 -> 10
   Union List: 2 -> 8 -> 20 -> 4 -> 15 -> 10
 */
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    Node head;
    public Node add(int data) {
        if(head == null) {
            head = new Node(data);
            return head;
        }

        Node newNode = new Node(data);
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
        return head;
    }

}
public class SetOperation {
    //finding union

    /* 
     * To find the union of two linked list, I have created a set, iterated through each node and added the element
     * of each node into the set and then created new linked list
     */
    public Node union(Node node1, Node node2) {
        //converting node1  and node2 into hashset
        HashSet<Integer> set = new HashSet<>();
        Node lastNode1 = node1;
        while(lastNode1 != null) {
            set.add(lastNode1.data);
            lastNode1 = lastNode1.next;
        }

        Node lastNode2 = node2;
        while(lastNode2 != null) {
            set.add(lastNode2.data);
            lastNode2 = lastNode2.next;
        }
        return convertIntoNode(set);
    }

    //finding intersection
    public Node intersection(Node node1, Node node2) {
        //converting node1 to set

        /* 
         * To find the intersection of two node, I have converted each node to sets
         * After that, If have converted the common element to linked list
         */
        HashSet<Integer> set1 = new HashSet<>();
        Node lastNode1 = node1;
        while(lastNode1 != null) {
            set1.add(lastNode1.data);
            lastNode1 = lastNode1.next;
        }

        //converting node2 to set
        HashSet<Integer> set2 = new HashSet<>();
        Node lastNode2 = node2;
        while(lastNode2!= null) {
            set2.add(lastNode2.data);
            lastNode2= lastNode2.next;
        }
        HashSet<Integer> commonElements = new HashSet<>();
    
        for(Integer data: set1) {
            if(set2.contains(data)) {
                commonElements.add(data);
            }
        }
        return convertIntoNode(commonElements);
    }

    public void print(Node node) {
        if(node == null) {
            System.out.println("Node data...");
            return;
        }

        Node lastNode = node;
        while(lastNode != null) {
            System.out.print("->"+lastNode.data);
            lastNode = lastNode.next;
        }
        System.out.println("");
    }
    public Node convertIntoNode(HashSet<Integer> elems) {
        Node head = null;
        Node lastNode = null;
        for(Integer elem: elems) {
            if(head == null) {
                head = new Node(elem);
                lastNode = head;
            }else {
                Node newNode = new Node(elem);
                lastNode.next = newNode;
                lastNode = newNode;
            }
           
        }
        return head;
    }

    public static void main(String[] args) {
        //create two node
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(9);
        Node node1 = list.add(4);

        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(6);
        list2.add(9);
        list2.add(1);
        Node node2 = list2.add(4);

        SetOperation operation = new SetOperation();
        Node union = operation.union(node1, node2);
        Node intersection = operation.intersection(node1, node2);

        System.out.println("Union Node data...");
        operation.print(union);
        System.out.println("Intersection Node data...");
        operation.print(intersection);
    }

}
