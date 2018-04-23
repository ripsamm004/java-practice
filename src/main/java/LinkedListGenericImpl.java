/**
 * Created by shiful on 19/04/2018.
 *
 * https://malalanayake.wordpress.com/2014/06/15/simple-linkedlist-implementation-with-java-generics/
 */
public class LinkedListGenericImpl<T> {

    Node<T> head;

    public void add(T value) {
        Node<T> node = new Node();
        node.setValue(value);
        node.setNextNode(null); // if i don't setNextNode this by default the value of a object is null


        if (head == null) {
            head = node;
        } else {

            Node<T> lastNode = head;


            // travels the last node
            while(lastNode.getNextNode()!=null){
                lastNode = lastNode.getNextNode();

            }

            // insert the new node int the last node
            lastNode.setNextNode(node);

        }
    }


    public void insertAtFirst(T value){
        Node<T> node = new Node<T>();
        node.setValue(value);
        node.setNextNode(null); // if i don't setNextNode this by default the value of a object is null


        if (head == null) {
            head = node;
        } else {

            Node fistNode = head;
            node.setNextNode(fistNode);
            head = node;

        }


    }

    public void insertAt(int index, T value){
        Node<T> node = new Node<T>();
        node.setValue(value);
        node.setNextNode(null); // if i don't setNextNode this by default the value of a object is null

        Node<T> insertionNode = null;
        Node<T> insertionPointNode = null;

        if(index==0){

            if(head!=null){
                node.setNextNode(head);
                head = node;
                return;
            }
            else System.out.println("NOT ELEMENT FOUND IN THAT HEAD POSITION");

        }
        else {
            insertionNode = head;
            int i = 1;
            while (i < index && insertionNode.getNextNode() != null) {
                insertionNode = insertionNode.getNextNode();
                i++;
            }
       }

        if(insertionNode.getNextNode() != null) {
            insertionPointNode = insertionNode.getNextNode();
            node.setNextNode(insertionPointNode);
            insertionNode.setNextNode(node);
        }
        else System.out.println("NOT ELEMENT FOUND IN THAT POSITION");
    }


    public void remove(T value){

        Node<T> lastNode = head;

        if(lastNode==null)
        {  System.out.println("NOT ELEMENT MATCH CAN NOT REMOVE");
            return;
        }
        else if(lastNode.getValue().equals(value)) {  // match the value with first node
            if(lastNode.getNextNode() !=null) {
                head = lastNode.getNextNode();
            }
            else head = null;

            return;
        }

        // Match the value from 2nd nodes and travers until the end
        while(lastNode !=null){
            if((lastNode.getNextNode() !=null)) {
                if(lastNode.getNextNode().getValue().equals(value)) {
                    lastNode.setNextNode((lastNode.getNextNode().getNextNode() != null ? lastNode.getNextNode().getNextNode() : null));
                    break;
                }
            }
            lastNode = lastNode.getNextNode();
        }


    }

    public void show(){
        Node<T> node = head;
        if(node==null) return;
        while (node.getNextNode()!=null){
            System.out.println(node.getValue());
            node = node.getNextNode();
        }

        System.out.println(node.getValue());
    }


    private class Node<T> {

        T value;
        Node<T> nextNode;

        public Node() {
            this.value = null;
            this.nextNode = null;
        }

        public Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }


}


