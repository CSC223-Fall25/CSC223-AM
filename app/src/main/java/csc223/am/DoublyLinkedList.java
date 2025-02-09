
package csc223.am;


public class DoublyLinkedList extends SinglyLinkedList{

    @Override
    public void insert(char item){
        Node new_item = new Node();
        new_item.data = item;
        if (this.head == null){
            this.head = new_item;
            this.tail = new_item;
        } else {
            this.tail.next = new_item;
            this.tail.next.previous = this.tail;
            this.tail = new_item;
        }
    }

    @Override
    public void remove(char item){
        if (this.head.data == item){
            this.head = this.head.next;
            this.head.previous = null;
        }
        Node curr = this.head;
        while (curr.next != null){
            if (curr.next.data == item){
                curr.next = curr.next.next;
                curr.next.previous = curr;
                break;
            } else {
                curr = curr.next;
            }
            
        }
        if (curr.next == null){
            this.tail = curr;
            curr.next = null;
        }
    }
    @Override
    public char getFirst(){
        return super.getFirst();
    }

    @Override
    public char getLast(){
        return super.getLast();
    }

    @Override
    public char get(int index){
        return super.get(index);

    }

    @Override
    public int size(){
        return super.size();
    }

    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }

    @Override
    public void clear(){
        super.clear();
    }

    @Override
    public boolean contains(char item){
        return super.contains(item);
    }

    @Override
    public int indexOf(char item){
        return super.indexOf(item);
    }

    @Override
    public int lastIndexOf(char item){
        return super.lastIndexOf(item);
    }

    @Override
    public void reverse(){
        Node curr = this.head;
        Node prev = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            curr.previous = next;
            prev = curr;
            curr = next;
        }
        this.head = prev;
        Node tail = this.head;
        while (tail.next != null){
            tail = tail.next;
        }
        this.tail = tail;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
