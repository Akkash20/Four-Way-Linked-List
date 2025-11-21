import java.util.*;

class Node {
    int data;
    Node next, prev, up, down;

    Node(int data) {
        this.data = data;
    }
}


class FourWayLink{

    List<Node> memory = new ArrayList<>();

    public Node createNode(int data){
        Node newNode = new Node(data);
        memory.add(newNode);
        return newNode;
    }

    public void connectTop(Node child, Node parent) {
        if (!memory.contains(child))memory.add(child);
        if (!memory.contains(parent))memory.add(parent);
        child.up = parent;
    }

    public void connectBottom(Node parent, Node child) {
        if (!memory.contains(child))memory.add(child);
        if (!memory.contains(parent))memory.add(parent);
        parent.down = child;
    }

    public void connectLeft(Node rightNode, Node leftNode) {
        if (!memory.contains(rightNode))memory.add(rightNode);
        if (!memory.contains(leftNode))memory.add(leftNode);
        rightNode.prev = leftNode;

    }

    public void connectRight(Node leftNode, Node rightNode) {
        if (!memory.contains(rightNode))memory.add(rightNode);
        if (!memory.contains(leftNode))memory.add(leftNode);
        leftNode.next = rightNode;
    }

    public void deleteNode(Node temp){
        memory.remove(temp);
        temp.up = temp.down = temp.prev = temp.next = null;

        for(Node i : memory){
            if(i.up==temp)i.up=null;
            if(i.down==temp)i.down=null;
            if(i.prev==temp)i.prev=null;
            if(i.next==temp)i.next=null;
        }
    }

}



public class FourWayLinkedList {
    
    public static void main(String[] args) {
        FourWayLink fw = new FourWayLink();

        Node n1 = fw.createNode(1);
        Node n2 = fw.createNode(2);
        Node n3 = fw.createNode(3);
        Node n4 = fw.createNode(4);
        Node n5 = fw.createNode(5);
        Node n6 = fw.createNode(6);
        fw.connectTop(n1, n2);
        fw.connectRight(n1, n3);
        fw.connectBottom(n1, n4);
        fw.connectLeft(n1, n5);
        fw.connectBottom(n2, n1);
        fw.connectBottom(n5, n4);
        fw.connectRight(n5, n2);
        fw.connectBottom(n6, n3);
        fw.connectLeft(n6, n2);
       


        System.out.println(fw.memory);
        fw.deleteNode(n1);
        System.out.println(fw.memory);
    }
}
