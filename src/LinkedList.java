/**
 * Created by bradl on 10/5/2016.
 */
public class LinkedList<T> {
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    // Adds the data provided to a node at the end of the list.
    public void add(T data){

        // If the list is empty, well simply create a new node and set the head to this node.
        if(head == null){
            head = new Node(data);
        }else{
            // Otherwise, loop through until the end of the list and add it there
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }

            current.setNext(new Node(data));
        }

        incSize();
    }

    // Removes the node at the given index. Returns true if it was removed, false if none was found.
    public boolean remove(int index){

        if(index < 0 || index >= size()){
            return false;
        }

        // Handle the special case that the node we are trying to remove is the head.
        if(index == 0){
            head = head.getNext();
            decSize();
            return true;
        }

        // Loop through to the desired index
        Node current = head;
        for(int i=0; i<index - 1; i++){
            current = current.getNext();
        }

        current.setNext((current.getNext().getNext()));
        decSize();
        return true;
    }

    // Returns the size of the list
    public int size(){
        return this.size;
    }

    // Basic functions to keep us at the same ring of abstraction in other methods.
    private void incSize(){
        size++;
    }
    private void decSize(){
        size--;
    }


    // Returns the data at the provided index.
    public T get(int index){
        if(index < 0 || head == null){
            return null;
        }

        Node current = head;
        for(int i = 0; i < index; i++){
            if(current.getNext() == null){
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public String toString(){
        String s = "";
        if(head != null){
            Node current = head;
            while(current!=null){
                s += current.toString();
                current = current.getNext();
            }
        }

        return s;
    }


    /* -------------------------------------------NODE CLASS---------------------------------------------------*/
    private class Node{

        // Data and next values.
        private T data;
        private Node next;

        // Constructor that takes only data with no next pointer.
        public Node(T data){
            this.data = data;
            this.next = null;
        }

        // Constructor that initializes a node with data and a next pointer.
        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        // Getters and Setters.
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }
}